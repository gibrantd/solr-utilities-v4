package mx.com.dsa.solrutilities.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jfconavarrete
 */

public class SimpleFacet {

    private String nombre;
    private Long conteo;
    private List<SimpleFacet> valores;

    public SimpleFacet() {
    }

    public SimpleFacet(String nombre) {
        this.nombre = nombre;
        this.valores = new ArrayList<SimpleFacet>();
    }

    public SimpleFacet(String nombre, Long conteo) {
        this.nombre = nombre;
        this.conteo = conteo;
    }

    public SimpleFacet(String nombre, List<SimpleFacet> valores) {
        this.nombre = nombre;
        this.valores = valores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getConteo() {
        return conteo;
    }

    public void setConteo(Long conteo) {
        this.conteo = conteo;
    }

    public List<SimpleFacet> getValores() {
        return valores;
    }

    public void setValores(List<SimpleFacet> valores) {
        this.valores = valores;
    }

    @Override
    public String toString() {
        return "SimpleFacet [nombre=" + nombre + ", conteo=" + conteo +
                ", valores=" + valores + "]";
    }
    
}
