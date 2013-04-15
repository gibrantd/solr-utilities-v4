/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dsa.solrutilities.dto;

import java.util.List;
import org.apache.solr.client.solrj.beans.Field;

/**
 *
 * @author gibran
 */
public class Bean {
    @Field
    private String id;
    
    @Field("name")
    private String name;
    
    @Field("cat")
    private List<String> cat;

    public Bean() {
    }

    public Bean(String id, String name, List<String> cat) {
        this.id = id;
        this.name = name;
        this.cat = cat;
    }

  

    public List<String> getCat() {
        return cat;
    }

    public void setCat(List<String> cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    


    
    
}
