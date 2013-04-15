package mx.com.dsa.solrutilities.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jfconavarrete
 */

public class SimpleStatistic {

    private String nombre;    
    private Map<String,Double> valores;

    public SimpleStatistic() {
    }

    public SimpleStatistic(String nombre) {
        this.nombre = nombre;
        this.valores = new HashMap<String, Double>();
    }


    public SimpleStatistic(String nombre, Map<String, Double> valores) {
        this.nombre = nombre;
        this.valores = valores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public Map<String, Double> getValores() {
        return valores;
    }

    public void setValores(Map<String, Double> valores) {
        this.valores = valores;
    }

    @Override
    public String toString() {
        return "SimpleFacet [nombre=" + nombre + 
                ", valores=" + valores + "]";
    }
    
}
