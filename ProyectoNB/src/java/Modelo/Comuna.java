package Modelo;
// Generated 02-04-2012 02:50:57 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Comuna generated by hbm2java
 */
public class Comuna  implements java.io.Serializable {


     private int comunaId;
     private Provincia provincia;
     private String comunaNombre;
     private Set<Estacion> estacions = new HashSet<Estacion>(0);

    public Comuna() {
    }

	
    public Comuna(int comunaId) {
        this.comunaId = comunaId;
    }
    public Comuna(int comunaId, Provincia provincia, String comunaNombre, Set<Estacion> estacions) {
       this.comunaId = comunaId;
       this.provincia = provincia;
       this.comunaNombre = comunaNombre;
       this.estacions = estacions;
    }
   
    public int getComunaId() {
        return this.comunaId;
    }
    
    public void setComunaId(int comunaId) {
        this.comunaId = comunaId;
    }
    public Provincia getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    public String getComunaNombre() {
        return this.comunaNombre;
    }
    
    public void setComunaNombre(String comunaNombre) {
        this.comunaNombre = comunaNombre;
    }
    public Set<Estacion> getEstacions() {
        return this.estacions;
    }
    
    public void setEstacions(Set<Estacion> estacions) {
        this.estacions = estacions;
    }




}


