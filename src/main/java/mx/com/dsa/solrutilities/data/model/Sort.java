/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dsa.solrutilities.data.model;

import javax.swing.SortOrder;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;

/**
 *
 * @author Attivio
 */
public class Sort {
    
    public SolrQuery.ORDER order;
    public String name;
    public Sort(String name){
        this.name=name;
    }
    
    public Sort(String name, SolrQuery.ORDER order){
        this.name=name;
        this.order =order; 
    }

    public ORDER getOrder() {
        return order;
    }

    public void setOrder(ORDER order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
