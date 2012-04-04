package Modelo;
// Generated 02-04-2012 02:50:57 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Alarma generated by hbm2java
 */
public class Alarma  implements java.io.Serializable {


     private Integer idAlarma;
     private Sensor sensor;
     private TipoAlarma tipoAlarma;
     private int idMicro;
     private Integer idDato;
     private Date inicio;
     private Date fin;
     private Set<RegistroAlarma> registroAlarmas = new HashSet<RegistroAlarma>(0);

    public Alarma() {
    }

	
    public Alarma(Sensor sensor, TipoAlarma tipoAlarma, int idMicro) {
        this.sensor = sensor;
        this.tipoAlarma = tipoAlarma;
        this.idMicro = idMicro;
    }
    public Alarma(Sensor sensor, TipoAlarma tipoAlarma, int idMicro, Integer idDato, Date inicio, Date fin, Set<RegistroAlarma> registroAlarmas) {
       this.sensor = sensor;
       this.tipoAlarma = tipoAlarma;
       this.idMicro = idMicro;
       this.idDato = idDato;
       this.inicio = inicio;
       this.fin = fin;
       this.registroAlarmas = registroAlarmas;
    }
   
    public Integer getIdAlarma() {
        return this.idAlarma;
    }
    
    public void setIdAlarma(Integer idAlarma) {
        this.idAlarma = idAlarma;
    }
    public Sensor getSensor() {
        return this.sensor;
    }
    
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
    public TipoAlarma getTipoAlarma() {
        return this.tipoAlarma;
    }
    
    public void setTipoAlarma(TipoAlarma tipoAlarma) {
        this.tipoAlarma = tipoAlarma;
    }
    public int getIdMicro() {
        return this.idMicro;
    }
    
    public void setIdMicro(int idMicro) {
        this.idMicro = idMicro;
    }
    public Integer getIdDato() {
        return this.idDato;
    }
    
    public void setIdDato(Integer idDato) {
        this.idDato = idDato;
    }
    public Date getInicio() {
        return this.inicio;
    }
    
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    public Date getFin() {
        return this.fin;
    }
    
    public void setFin(Date fin) {
        this.fin = fin;
    }
    public Set<RegistroAlarma> getRegistroAlarmas() {
        return this.registroAlarmas;
    }
    
    public void setRegistroAlarmas(Set<RegistroAlarma> registroAlarmas) {
        this.registroAlarmas = registroAlarmas;
    }




}


