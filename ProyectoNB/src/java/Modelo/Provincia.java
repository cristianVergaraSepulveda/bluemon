package Modelo;
// Generated 19-03-2012 12:56:24 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Provincia generated by hbm2java
 */
public class Provincia  implements java.io.Serializable {


     private int provinciaId;
     private Region region;
     private String provinciaNombre;
     private Set<Comuna> comunas = new HashSet<Comuna>(0);

    public Provincia() {
    }

	
    public Provincia(int provinciaId) {
        this.provinciaId = provinciaId;
    }
    public Provincia(int provinciaId, Region region, String provinciaNombre, Set<Comuna> comunas) {
       this.provinciaId = provinciaId;
       this.region = region;
       this.provinciaNombre = provinciaNombre;
       this.comunas = comunas;
    }
   
    public int getProvinciaId() {
        return this.provinciaId;
    }
    
    public void setProvinciaId(int provinciaId) {
        this.provinciaId = provinciaId;
    }
    public Region getRegion() {
        return this.region;
    }
    
    public void setRegion(Region region) {
        this.region = region;
    }
    public String getProvinciaNombre() {
        return this.provinciaNombre;
    }
    
    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }
    public Set<Comuna> getComunas() {
        return this.comunas;
    }
    
    public void setComunas(Set<Comuna> comunas) {
        this.comunas = comunas;
    }




}

