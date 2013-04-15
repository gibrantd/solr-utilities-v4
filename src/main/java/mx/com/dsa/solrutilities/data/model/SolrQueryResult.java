package mx.com.dsa.solrutilities.data.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author jfconavarrete
 */
 
public class SolrQueryResult {
    
    private long totalDocumentsFound;
    private Map<String,SimpleFacet> facets;    
    private Map<String,SimpleStatistic> statistics;    
    private List<?> documents;
    
    public SolrQueryResult() {
    }

    public SolrQueryResult(long totalDocumentsFound, List<?> documents,Map<String, SimpleFacet> facets, Map<String,SimpleStatistic> statistics) {
        this.totalDocumentsFound = totalDocumentsFound;
        this.facets = facets;
        this.statistics = statistics;
        this.documents = documents;
    }

  

    public List<?> getDocuments() {
        return documents;
    }

    public void setDocuments(List<?> documents) {
        this.documents = documents;
    }

    public Map<String,SimpleFacet> getFacets() {
        return facets;
    }

    public void setFacets(Map<String,SimpleFacet> facets) {
        this.facets = facets;
    }

    public long getTotalDocumentsFound() {
        return totalDocumentsFound;
    }

    public void setTotalDocumentsFound(long totalDocumentsFound) {
        this.totalDocumentsFound = totalDocumentsFound;
    }

    public Map<String, SimpleStatistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(Map<String, SimpleStatistic> statistics) {
        this.statistics = statistics;
    }

 
    
}
