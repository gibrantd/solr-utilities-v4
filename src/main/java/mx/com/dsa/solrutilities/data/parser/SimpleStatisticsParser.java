/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dsa.solrutilities.data.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mx.com.dsa.solrutilities.data.model.SolrStatistics;
import mx.com.dsa.solrutilities.data.model.SimpleStatistic;
import org.apache.solr.client.solrj.response.FieldStatsInfo;
import org.apache.solr.client.solrj.response.QueryResponse;

/**
 *
 * @author gibran
 */
public class SimpleStatisticsParser implements StatisticsParser {

  
    
    @Override
    public Map<String, SimpleStatistic> parse(QueryResponse queryResponse) throws NumberFormatException{
        
        Map<String, FieldStatsInfo> statsInfo = queryResponse.getFieldStatsInfo();                         
        Map<String, SimpleStatistic> facetStatistics = new LinkedHashMap<String, SimpleStatistic>();                        
        
         
        if(statsInfo == null) {
            return facetStatistics;
        }    
        
        for (String facet : statsInfo.keySet()) {            
            SimpleStatistic statistic = new SimpleStatistic(facet);            
            Map<String,Double> valores = new HashMap<String, Double>();
                        
            valores.put(SolrStatistics.COUNT, statsInfo.get(facet).getCount().doubleValue());
            valores.put(SolrStatistics.MISSING, statsInfo.get(facet).getCount().doubleValue());
            valores.put(SolrStatistics.MAX, new Double(statsInfo.get(facet).getMax().toString()));
            valores.put(SolrStatistics.MIN, new Double(statsInfo.get(facet).getMin().toString()));
            valores.put(SolrStatistics.MEAN, new Double(statsInfo.get(facet).getMean().toString()));
            valores.put(SolrStatistics.STDDEV, new Double(statsInfo.get(facet).getStddev().toString()));
            valores.put(SolrStatistics.SUM, new Double(statsInfo.get(facet).getSum().toString()));           
            statistic.setValores(valores);            
            facetStatistics.put(facet, statistic);
            
        }
        return facetStatistics;
    }
}
