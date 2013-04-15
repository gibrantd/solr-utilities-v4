/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.dsa.solrutilities.dto;

/**
 *
 * @author Attivio
 */
public class SimpleDocumentDto {
 
    private String attrDate;
    private String attrFecha;
    private String attrFuente;
    private String attrImagen;    
    private String attrMedio;
    private String attrTeaser;
    private String attrTema;
    private String attrTexto;
    private String attrTitulo;    

    public String getAttrDate() {
        return attrDate;
    }

    public void setAttrDate(String attrDate) {
        this.attrDate = attrDate;
    }

    public String getAttrFecha() {
        return attrFecha;
    }

    public void setAttrFecha(String attrFecha) {
        this.attrFecha = attrFecha;
    }

    public String getAttrFuente() {
        return attrFuente;
    }

    public void setAttrFuente(String attrFuente) {
        this.attrFuente = attrFuente;
    }

    public String getAttrImagen() {
        return attrImagen;
    }

    public void setAttrImagen(String attrImagen) {
        this.attrImagen = attrImagen;
    }

    public String getAttrMedio() {
        return attrMedio;
    }

    public void setAttrMedio(String attrMedio) {
        this.attrMedio = attrMedio;
    }

    public String getAttrTeaser() {
        return attrTeaser;
    }

    public void setAttrTeaser(String attrTeaser) {
        this.attrTeaser = attrTeaser;
    }

    public String getAttrTema() {
        return attrTema;
    }

    public void setAttrTema(String attrTema) {
        this.attrTema = attrTema;
    }

    public String getAttrTexto() {
        return attrTexto;
    }

    public void setAttrTexto(String attrTexto) {
        this.attrTexto = attrTexto;
    }

    public String getAttrTitulo() {
        return attrTitulo;
    }

    public void setAttrTitulo(String attrTitulo) {
        this.attrTitulo = attrTitulo;
    }

    
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleDocumentDto other = (SimpleDocumentDto) obj;
        if ((this.attrFecha == null) ? (other.attrFecha != null) : !this.attrFecha.equals(other.attrFecha)) {
            return false;
        }
        if ((this.attrTitulo == null) ? (other.attrTitulo != null) : !this.attrTitulo.equals(other.attrTitulo)) {
            return false;
        }
        if ((this.attrFuente == null) ? (other.attrFuente != null) : !this.attrFuente.equals(other.attrFuente)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.attrFecha != null ? this.attrFecha.hashCode() : 0);
        hash = 59 * hash + (this.attrTitulo != null ? this.attrTitulo.hashCode() : 0);
        hash = 59 * hash + (this.attrFuente != null ? this.attrFuente.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return  "SimpleDocumentDto{" + "attrDate=" + attrDate + ", attrFecha=" + attrFecha + ", attrFuente=" + attrFuente + ", attrImagen=" + attrImagen + ", attrMedio=" + attrMedio + ", attrTeaser=" + attrTeaser + ", attrTema=" + attrTema + ", attrTexto=" + attrTexto + ", attrTitulo=" + attrTitulo + '}';
    }

    
            
    
}
