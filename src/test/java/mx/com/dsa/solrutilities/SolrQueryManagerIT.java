/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dsa.solrutilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import mx.com.dsa.solrutilities.data.dao.SolrProcessorDao;
import mx.com.dsa.solrutilities.data.dao.SolrQueryManager;
import mx.com.dsa.solrutilities.data.helper.QueryRequestBuilder;
import mx.com.dsa.solrutilities.data.model.SolrQueryResult;
import mx.com.dsa.solrutilities.data.model.SolrStatistics;
import mx.com.dsa.solrutilities.data.model.Sort;
import mx.com.dsa.solrutilities.data.model.SimpleFacet;
import mx.com.dsa.solrutilities.data.model.SimpleStatistic;
import mx.com.dsa.solrutilities.data.parser.SimpleDocumentDtoParser;
import mx.com.dsa.solrutilities.data.parser.SimpleStatisticsParser;
import mx.com.dsa.solrutilities.dto.Bean;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.request.SimpleFacets;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Attivio
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class SolrQueryManagerIT {

    @Resource
    private SolrServer server;
    @Resource
    private SolrQueryManager solrQueryManager;
    @Resource
    private SolrProcessorDao solrProcessor;

    @org.junit.Test
    public void testFindAll() throws SolrServerException, IOException {

        Map p = new HashMap();
        p.put("rows", "20");
        
        List<String> pf = new ArrayList<String>();
        pf.add("popularity");
        pf.add("cat");
        
        List flds = new ArrayList();
        flds.add("cat");
        flds.add("price");
        
        List hl = new ArrayList();
        hl.add("name");
        hl.add("manu");
        
        List fSts = new ArrayList();
        fSts.add("price");
        fSts.add("weight");
        
        List fq = new ArrayList();
        fq.add("inStock:true");
        fq.add("cat:memory");
        
        List f = new ArrayList();
        f.add("cat");
        f.add("manu_id_s");
        
        SolrQuery query = new QueryRequestBuilder("*:*")
                .parameters(p)                
                .parameter("rows", "20")
//                .pivotFields(pf)
//                .pivotFields("popularity,cat")                     
                .facetQuery("cat:\"hard drive\"")
//                .fields(flds)
//                .fields("cat,price")
                .hlFields("name,manu")
                .hlFields(hl)         
//                .fieldStatistics("price")
                .fieldsStatistics(fSts)
                .facetLimit(20)
                .facetMinCount(3)
                .facetMissing(true)   
//                .filters(fq)
//                .filter("cat:memory")
//                .filter("inStock:true")
                .rows(20)
                .offset(0)     
                .reqHandler("search")
//                .facet("cat")                
//                .facet("manu_id_s")  
                .facets(f)
                .build();
        QueryResponse response = server.query(query);
        System.out.println(response.getResults().getNumFound());
        System.out.println(response.getResults().size());
            
   

//       
//        
//        solrQueryManager.executeQuery(query);                
//        System.out.println(response.getResults().getNumFound());
//
//
//        SolrQueryResult res=  solrProcessor.processQuery(query);
//        System.out.println(res.getTotalDocumentsFound());
//        
//        
//        SimpleDocumentDtoParser simpleDocument = new SimpleDocumentDtoParser();                 
//        res=  solrProcessor.processQuery(query,simpleDocument);
//        System.out.println(res.getTotalDocumentsFound());
//        System.out.println(res.getDocuments().size());
        
        
        
        SolrQueryResult res= solrProcessor.processQuery(query,Bean.class);
        System.out.println(res.getTotalDocumentsFound());
        System.out.println(res.getDocuments().size());
        
        for (String keyF : res.getFacets().keySet()) {
            SimpleFacet sf =res.getFacets().get(keyF);
            System.out.println("Nombre:  "+sf.getNombre());
            System.out.println("Conteo:  "+sf.getConteo());
            for (SimpleFacet sfc : sf.getValores()) {
                System.out.println("    Nombre:  "+sfc.getNombre());
                System.out.println("    Conteo:  "+sfc.getConteo());                
            }                        
        }
        
        for( String keyS: res.getStatistics().keySet()){
            SimpleStatistic ss = res.getStatistics().get(keyS);
            System.out.println("Nombre:  "+ss.getNombre());
            System.out.println("    Suma:"+ss.getValores().get(SolrStatistics.MAX));
            for (String keyV : ss.getValores().keySet()) {
                System.out.println("        "+keyV+"    "+ss.getValores().get(keyV));
            }
            
        }
        
        
//        
//        


    }
}
