package mx.com.dsa.solrutilities.data.dao;


import java.util.List;
import mx.com.dsa.solrutilities.data.model.SolrQueryResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 *
 * @author jfconavarrete
 */

public interface SolrProcessorDao{
    
    SolrQueryResult processQuery(SolrQuery queryRequest, List<String> facets, List<String> filters);    
    SolrQueryResult processQuery(SolrQuery queryRequest);    
        
    SolrQueryResult processQuery(SolrQuery queryRequest, Class bean);
    
}
