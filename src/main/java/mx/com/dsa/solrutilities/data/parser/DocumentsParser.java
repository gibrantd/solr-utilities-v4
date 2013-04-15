package mx.com.dsa.solrutilities.data.parser;


import java.util.List;
import org.apache.solr.client.solrj.response.QueryResponse;


/**
 *
 * @author jfconavarrete
 */

public interface DocumentsParser<T> {

    List<T> parse(QueryResponse queryResponse);
    
}
