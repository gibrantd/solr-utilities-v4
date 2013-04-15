package mx.com.dsa.solrutilities.data.parser;


import java.util.Map;
import org.apache.solr.client.solrj.response.QueryResponse;
import mx.com.dsa.solrutilities.data.model.SimpleFacet;


/**
 *
 * @author jfconavarrete
 */

public interface FacetsParser {
    
    Map<String,SimpleFacet> parse(QueryResponse queryResponse);
    
}
