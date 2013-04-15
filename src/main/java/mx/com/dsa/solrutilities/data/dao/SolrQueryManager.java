package mx.com.dsa.solrutilities.data.dao;

import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;



/**
 *
 * @author jfconavarrete
 */

public interface SolrQueryManager {
        
    QueryResponse executeQuery(SolrQuery queryRequest);    
    QueryResponse executeQuery(SolrQuery queryRequest, List<String> facets, List<String> filters);    
    SolrServer getServer();
    
    
}
