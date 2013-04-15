package mx.com.dsa.solrutilities.data.dao;


import java.util.List;
import java.util.Map;
import mx.com.dsa.solrutilities.data.model.SimpleFacet;
import mx.com.dsa.solrutilities.data.model.SimpleStatistic;
import mx.com.dsa.solrutilities.data.model.SolrQueryResult;
import mx.com.dsa.solrutilities.data.parser.FacetsParser;
import mx.com.dsa.solrutilities.data.parser.SimpleFacetsParser;
import mx.com.dsa.solrutilities.data.parser.SimpleStatisticsParser;
import mx.com.dsa.solrutilities.data.parser.StatisticsParser;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jfconavarrete
 */

public class SolrProcessorDaoImpl implements SolrProcessorDao {
              
    protected SolrQueryManager solrQueryManager;
    protected Class documentsParser;
    protected FacetsParser facetsParser = new SimpleFacetsParser();    
    protected StatisticsParser statisticsParser = new SimpleStatisticsParser();   
    
    private static Logger logger = LoggerFactory.getLogger(SolrProcessorDaoImpl.class);

    public void setDocumentsParser(Class documentsParser) {        
        this.documentsParser = documentsParser;
    }

    public void setFacetsParser(FacetsParser facetsParser) {
        this.facetsParser = facetsParser;
    }

    public void setSolrQueryManager(SolrQueryManager solrQueryManager) {
        this.solrQueryManager = solrQueryManager;
    }

    public void setStatisticsParser(StatisticsParser statisticsParser) {
        this.statisticsParser = statisticsParser;
    }

    
    
    @Override
    public SolrQueryResult processQuery(SolrQuery queryRequest) {        
        QueryResponse queryResponse = solrQueryManager.executeQuery(queryRequest);        
        return processResult(queryResponse);
    }
    
    @Override
    public SolrQueryResult processQuery(SolrQuery queryRequest, List<String> facets, List<String> filters) {
        QueryResponse queryResponse = solrQueryManager.executeQuery(queryRequest, facets, filters);
        return processResult(queryResponse);
    }        
    
   
    
    
    public SolrQueryResult processQuery(SolrQuery queryRequest, Class beanClass) {
        QueryResponse queryResponse = solrQueryManager.executeQuery(queryRequest);
        return processResult(queryResponse, beanClass);
    }
    
    protected SolrQueryResult processResult(QueryResponse response) {        
        List parsedDocuments = documentsParser == null ? null : response.getBeans(documentsParser);
        Map<String,SimpleFacet> parsedFacets=facetsParser.parse(response);                 
        Map<String,SimpleStatistic> parsedStatistics = statisticsParser.parse(response);  
        long documentsFound = response.getResults().getNumFound();        
        return new SolrQueryResult(documentsFound, parsedDocuments, parsedFacets,parsedStatistics);
    }
    

   protected SolrQueryResult processResult(QueryResponse response, Class beanClass){
        List parsedDocuments = response.getBeans(beanClass);
         Map<String,SimpleFacet> parsedFacets=facetsParser.parse(response);
        Map<String,SimpleStatistic> parsedStatistics = statisticsParser.parse(response); 
        long documentsFound = response.getResults().getNumFound();
        return new SolrQueryResult(documentsFound, parsedDocuments, parsedFacets,parsedStatistics);
    }
  

}
