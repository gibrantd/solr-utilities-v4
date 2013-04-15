package mx.com.dsa.solrutilities.data.helper;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.dsa.solrutilities.data.model.Sort;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.params.MapSolrParams;

/**
 *
 * @author jfconavarrete
 */
public class QueryRequestBuilder {

     
    
    private String query;
    private int offset;
    private int rows = 10;
    private List<String> facets = new ArrayList<String>();
    private List<String> filters = new ArrayList<String>();    
    private List<String> fields =  new ArrayList<String>();     
    private Sort sort;
    
    private String fieldSort=null;
   
    // solr 4.2
    private Map<String, String> parametros = new HashMap<String, String>();
    private String pivotFields=null;
    private String facetQuery=null;
    private String hlFields = null;     
    private List<String> fieldsStatistics =  new ArrayList<String>();   
    private int facetLimit=10;
    private int facetMinCount;
    private boolean facetMissing=false;
    private String reqHandler="search";
    
    
    
    //Metodos de Apoyo
    public QueryRequestBuilder parameter(String key,String value){    
       this.parametros.put(key, value);
       return this;
    }
    
    
    public QueryRequestBuilder(String query) {
        this.query = query;
    }

    
    
    public QueryRequestBuilder rows(int rows) {
        this.rows = rows;
        return this;
    }

    public QueryRequestBuilder facetLimit(int facetLimit) {
        this.facetLimit = facetLimit;
        return this;
    }
    
     public QueryRequestBuilder facetMinCount(int facetMinCount) {
        this.facetMinCount = facetMinCount;
        return this;
    }
     
       public QueryRequestBuilder facetMissing(boolean facetMissing) {
        this.facetMissing = facetMissing;
        return this;
    } 
     
    public QueryRequestBuilder offset(int offset) {
        this.offset = offset;
        return this;
    }

    public QueryRequestBuilder filters(List<String> filters) {
        this.filters.addAll(filters);
        return this;
    }
          
    
    public QueryRequestBuilder filter(String filter) {
        this.filters.add(filter);
        return this;
    }

    public QueryRequestBuilder sort(Sort sort) {
        this.sort = sort;
        return this;
    }
    
    public QueryRequestBuilder facet(String facet) {
        this.facets.add(facet);
        return this;
    }
    
    public QueryRequestBuilder facets(List<String> facets) {
        this.facets.addAll(facets);
        return this;
    }
    
    public QueryRequestBuilder fields(String field) {
        this.fields.add(field);
        return this;
    }
    
    public QueryRequestBuilder fields(List<String> fields) {
        this.fields = fields;
        return this;
    }
    public QueryRequestBuilder fieldStatistics(String fieldStatistics) {
        this.fieldsStatistics.add(fieldStatistics);
        return this;
    }
    
    public QueryRequestBuilder fieldsStatistics(List<String> fieldsStatistics) {
        this.fieldsStatistics = fieldsStatistics;
        return this;
    }
 
    public QueryRequestBuilder hlFields(String hlFields) {
        this.hlFields=hlFields;
        return this;
    }
    
    public QueryRequestBuilder hlFields(List<String> hlFields) {
        this.hlFields = hlFields.toString().replaceAll("[\\[|\\]|\\s]","");        
        return this;
    }
    
    public QueryRequestBuilder parameters(Map<String, String> parametros) {
        this.parametros = parametros;
        return this;
    }
    
    public QueryRequestBuilder pivotFields(List<String> pivotFields) {
        this.pivotFields = pivotFields.toString().replaceAll("[\\[|\\]|\\s]","");      
        return this;
    }

     public QueryRequestBuilder pivotFields(String pivotFields){      
        this.pivotFields=pivotFields;
        return this;
    }
     
    public QueryRequestBuilder facetQuery(String facetQuery){      
        this.facetQuery=facetQuery;
        return this;
    } 
    
     public QueryRequestBuilder reqHandler(String reqHandler){      
        this.reqHandler=reqHandler;
        return this;
    } 
    
    
    public SolrQuery build() {
        SolrQuery queryRequest = new SolrQuery();        
        queryRequest.addFacetField(facets.toArray(new String[facets.size()]));        
        queryRequest.setQuery(query);
        queryRequest.setRows(rows);
        queryRequest.setFilterQueries(filters.toArray(new String[filters.size()]));
        queryRequest.setStart(offset);        
        queryRequest.setFields(fields.toArray(new String[fields.size()]));                        
        if(sort!=null){
            queryRequest.addSortField(sort.getName(),sort.getOrder());
        }    
        
        //solr 4.2
        queryRequest.add(new MapSolrParams(parametros));     //agrega parametros por un Map    
        queryRequest.addFacetPivotField(pivotFields);
        queryRequest.addFacetQuery(facetQuery);
        queryRequest.addHighlightField(hlFields.toString());
        for (String fS : fieldsStatistics) {
            queryRequest.setGetFieldStatistics(fS);
        }
        queryRequest.setFacetLimit(facetLimit);
        queryRequest.setFacetMinCount(facetMinCount);
        queryRequest.setFacetMissing(facetMissing);
        queryRequest.setRequestHandler(reqHandler);
        
        
        
        return queryRequest;
    }
    
}
