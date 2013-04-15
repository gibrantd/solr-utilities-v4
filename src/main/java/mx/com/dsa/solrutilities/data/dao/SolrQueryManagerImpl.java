package mx.com.dsa.solrutilities.data.dao;


import java.util.List;
import mx.com.dsa.solrutilities.data.exception.QueryException;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author gibran
 */

public class SolrQueryManagerImpl implements SolrQueryManager {
    
    protected SolrServer server;             
    
    private static Logger logger = LoggerFactory.getLogger(SolrQueryManagerImpl.class);

    public QueryResponse executeQuery(SolrQuery queryRequest) {
        QueryResponse response;
         try {                              
            long tiempoInicio = System.currentTimeMillis();                        
            response = server.query(queryRequest);
            System.out.println("Tiempo: " + (System.currentTimeMillis() - tiempoInicio));
        } catch (SolrServerException se) {                        
            RuntimeException exception = new QueryException("Error al hacer la query con Solr", se);
            logger.error(exception.getMessage(), exception);
            throw exception;
        }                
        return response;                        
    }

    public QueryResponse executeQuery(SolrQuery queryRequest, List<String> facets, List<String> filters) {
        addFacetsToQuery(facets, queryRequest);
        addFiltersToQuery(filters, queryRequest);
        QueryResponse queryResponse = executeQuery(queryRequest); 
        return queryResponse;
    }

    

    
     protected void addFacetsToQuery(List<String> facets, SolrQuery queryRequest) {       
        if (facets == null) {
            return;
        }
        queryRequest.addFacetField(facets.toArray(new String[]{}));                    
    }
    
    protected void addFiltersToQuery(List<String> filters, SolrQuery queryRequest) {        
        if (filters == null) {
            return;
        }
       for (String filter : filters) {                       
            queryRequest.addFilterQuery(filter);
        }
    }

    public SolrServer getServer() {
        return server;
    }

   
    public SolrServer setServer(SolrServer server) {
       return this.server=server;
    }

  

    

}
