package mx.com.dsa.solrutilities.data.parser;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Component;
import mx.com.dsa.solrutilities.data.model.SimpleFacet;

/**
 *
 * @author jfconavarrete
 */

@Component
public class SimpleFacetsParser implements FacetsParser {

    @Override
    public Map<String,SimpleFacet> parse(QueryResponse queryResponse) {
        List<FacetField> facetResponses = queryResponse.getFacetFields();   
        Map<String,SimpleFacet> facets = new LinkedHashMap<String,SimpleFacet>();
        
        if(facetResponses == null) {
            return facets;
        }        
        
        for (FacetField facetResponse : facetResponses ) {
                        
            String nombre = facetResponse.getName();            
            SimpleFacet facetPadre = new SimpleFacet(nombre);
            facetPadre.setConteo(new Long(facetResponse.getValueCount()));            
            for (FacetField.Count bucket :  facetResponse.getValues()) {
                SimpleFacet valorFaceta = new SimpleFacet();
                valorFaceta.setNombre(bucket.getName());
                valorFaceta.setConteo(bucket.getCount());
                facetPadre.getValores().add(valorFaceta);               
            }
            facets.put(facetPadre.getNombre(), facetPadre);        
        }
        
        
        return facets;
    }
    
}
