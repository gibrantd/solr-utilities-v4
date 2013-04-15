/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dsa.solrutilities.data.parser;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mx.com.dsa.solrutilities.dto.SimpleDocumentDto;
import mx.com.dsa.solrutilities.service.helper.StringUtils;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Attivio
 */
public class SimpleDocumentDtoParser  implements DocumentsParser<SimpleDocumentDto> {

    private final static Map<String,Field> fields = new HashMap<String, Field>();
    
    private static final Logger logger = LoggerFactory.getLogger(SimpleDocumentDtoParser.class);
    
    static {
        Class clazz = SimpleDocumentDto.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            fields.put(StringUtils.convertirCamelCaseEnGuionbajo(field.getName()), field);
        }
    }
    
    public List<SimpleDocumentDto> parse(QueryResponse queryResponse) {
       List<SimpleDocumentDto> documentos = new LinkedList<SimpleDocumentDto>();
        for (SolrDocument document : queryResponse.getResults()) {
            SimpleDocumentDto dto = new SimpleDocumentDto();            
            for (String name : fields.keySet()) {
                try {
                    Field field = fields.get(name);
                    Collection<Object> values = document.getFieldValues(name);
                    if(values != null && values.size() > 1) {                                                
                        field.set(dto, values.toString().substring(1, values.toString().length() - 1));                        
                    } else {
                        field.set(dto, document.getFirstValue(name));
                    }                    
                } catch (IllegalArgumentException ex) {
                    logger.error(ex.getMessage(), ex);
                } catch (IllegalAccessException ex) {
                    logger.error(ex.getMessage(), ex);
                }
            }                              
            documentos.add(dto);            
        }
        return documentos;
    }


    
}
