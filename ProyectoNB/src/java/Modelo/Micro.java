package Modelo;
// Generated 19-03-2012 12:56:24 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Micro generated by hbm2java
 */
public class Micro  implements java.io.Serializable {


     private Integer idMicro;
     private Estacion estacion;
     private String nombremicro;
     private Set<Dato> datos = new HashSet<Dato>(0);

    public Micro() {
    }

    public Micro(Estacion estacion, String nombremicro, Set<Dato> datos) {
       this.estacion = estacion;
       this.nombremicro = nombremicro;
       this.datos = datos;
    }
   
    public Integer getIdMicro() {
        return this.idMicro;
    }
    
    public void setIdMicro(Integer idMicro) {
        this.idMicro = idMicro;
    }
    public Estacion getEstacion() {
        return this.estacion;
    }
    
    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }
    public String getNombremicro() {
        return this.nombremicro;
    }
    
    public void setNombremicro(String nombremicro) {
        this.nombremicro = nombremicro;
    }
    public Set<Dato> getDatos() {
        return this.datos;
    }
    
    public void setDatos(Set<Dato> datos) {
        this.datos = datos;
    }




}


