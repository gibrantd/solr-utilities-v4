/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dsa.solrutilities.data.parser;

import java.util.Map;
import org.apache.solr.client.solrj.response.QueryResponse;
import mx.com.dsa.solrutilities.data.model.SimpleStatistic;

/**
 *
 * @author gibran
 */
public interface StatisticsParser {
    
    Map<String,SimpleStatistic> parse(QueryResponse queryResponse);
    
}
