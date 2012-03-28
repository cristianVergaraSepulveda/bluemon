/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Alarma;
import Modelo.Dato;
import Modelo.Estacion;
import Modelo.Micro;
import Modelo.Sensor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import Modelo.HibernateUtil;
import Modelo.Registro;
import org.hibernate.Query;
/**
 *
 * @author athanatos
 */
public class EstacionDAO extends HibernateUtil{
    
     Session session = null;
public EstacionDAO(){
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    
}

 public List getSensor(int microID) {
  List<Sensor> SensorList = null;
  try {
   org.hibernate.Transaction tx = session.beginTransaction();
   Query q = session.createQuery(" ");
   SensorList = (List<Sensor>) q.list();
  } catch (Exception e) {
   e.printStackTrace();
  }
  return SensorList;
 }
 public List getMicroxEstacion(int id){
    List<Micro> micro  = null; 
    try{
org.hibernate.Transaction tx = session.beginTransaction();
    Query q = session.createQuery("from Micro m where m.estacion ='"+id+"'");
    micro = (List<Micro>) q.list();
    //Criteria criterio = HibernateUtil.getSessionFactory().getCurrentSession().createCriteria("Modelo.Micro");
    }catch(Exception e){
        e.printStackTrace();
    }   
    return  micro;
}
/*#######################################################################*/
 // Obtiene los actores en un film particular
 public List getMicroByID(int microId) {
  List<Micro> actorList = null;
  try {
   org.hibernate.Transaction tx = session.beginTransaction();
   //query->from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + microId + "')
   Query q = session.createQuery("from Micro micro  where idMicro= '"+microId+"'");
   actorList = (List<Micro>) q.list();

  } catch (Exception e) {
   e.printStackTrace();
  }
  return actorList;
 }
 // Obtiene una lista de categorías de acuerdo al filmId
 /*public Sensor getSensorByID(int filmId) {
  Sensor sensor = new Sensor(); try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Sensor as s where s.idSensor ='" + filmId + "'");        
        sensor = (Sensor) q.uniqueResult();
        }catch (Exception e) {     e.printStackTrace(); }
  return sensor; }*/

/* // Obtiene el idioma del film de acuerdo a un langId
 public String getLangByID(int langId) {
  Language language = null;  try{
   org.hibernate.Transaction tx = session.beginTransaction();
   Query q = session.createQuery("from Language as lang where lang.languageId=" + langId);
   language = (Language) q.uniqueResult();  } catch (Exception e) {
   e.printStackTrace();  }  return language.getName(); }*/
 //Métodos para no poner código java en el JSPX
 int startId;
 int endId;
 
 public void setAttributeStartID(int startId){
  this.startId = startId;
 }
 public void setAttributeEndID(int endId){
  this.endId = endId;
 }
 
 public List getLoadEstacion(){
    List<Estacion> ListEstacion = null;
    org.hibernate.Transaction tx = null;
  try {
   tx = session.beginTransaction();
   //query->from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + microId + "')
   Query q = session.createQuery("from Estacion");
   ListEstacion = (List<Estacion>) q.list();
  
  } catch (Exception e) {
   e.printStackTrace();
   tx.rollback();
  }
   tx.commit();
  return ListEstacion;
   
 }
 
 public List getListaSensores(){        //usado
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        /*Transaction tx = */ session.beginTransaction();
       
        List<Sensor> sensores = null;
        sensores = session.createQuery("select  s.idSensor, s.nombresensor, s.unidadmedida  from Micro m, Sensor s, Dato d where s.idSensor = d.sensor and m.idMicro = d.micro")
.list();
        
        session.getTransaction().commit();
        session.close();
        return sensores;
 }
 
 public Sensor getSensorxID(int id){            //usado
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        /*Transaction tx = */ session.beginTransaction();
       Sensor sensor = new Sensor();
       sensor.setIdSensor(id);
       Sensor NS = new Sensor(); 
       NS = (Sensor) session.load(Sensor.class, id); 
               //.createQuery("from Sensor as s where s.idSensor = "+sensor.getIdSensor()+");
       return NS;
 }
 public List getDatoXidSensor(int id){      //   no usado 
   List<Dato> ListDato = null;
  try {
   org.hibernate.Transaction tx = session.beginTransaction();
   //query->from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + microId + "')
   Query q = session.createQuery("select d from Dato d, Sensor s  where d.sensor = s.id and d.sensor = '"+id+"'");
   ListDato = (List<Dato>) q.list();

  } catch (Exception e) {
   e.printStackTrace();
  }
  return ListDato;
   
 } 
 
  public List getDatoXidSensor2(int id) {   //usado
    List<Dato> ListDato = null;
    org.hibernate.Transaction tx= null;
  try {
  tx = session.beginTransaction();
   //query->from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + microId + "')
   Query q = session.createQuery("select d from Dato d, Sensor s  where d.sensor = s.id and d.sensor = '"+id+"' order by  d.idDato desc");
      //q.setFirstResult(1);
   q.setMaxResults(100);
   ListDato = (List<Dato>) q.list();

  } catch (Exception e) {
   e.printStackTrace();
   tx.rollback();
  }
  tx.commit();
  return ListDato;
 }
  public List getDatoRegistroxIdSensor2(int IdSensor){
  List<Registro> ListRegistro = null;
   org.hibernate.Transaction tx= null;
  try {
    tx = session.beginTransaction();
   //query->from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + microId + "')
   Query q = session.createQuery("select r from Dato d, Sensor s, Registro r where d.sensor = s.id  and r.dato =d.idDato and d.sensor = 1 order by  d.idDato desc");
      //q.setFirstResult(1);
   q.setMaxResults(100);
   ListRegistro = (List<Registro>) q.list();

  } catch (Exception e) {
   e.printStackTrace();
   tx.rollback();
  }
  tx.commit();
  return ListRegistro;
  }
  
  public Registro getRegistroDato(int id){          //usado
   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        /*Transaction tx = */ session.beginTransaction();
       Registro Result = new Registro();
       //Registro Result = (Registro) session.createQuery("from Registro r where r.dato ='"+id+"'").uniqueResult();
       //Result = (Registro) session.load(Registro.class, registro.getIdRegistro());
       //.createQuery("from Sensor as s where s.idSensor = "+sensor.getIdSensor()+");
       session.getTransaction().commit();
       session.close();
       return Result;
  }
  
  
  public Registro getRegistroDato2(int id){          //usado
   
   Registro Result = new Registro();
        try {
   org.hibernate.Transaction tx = session.beginTransaction();
   
   Result = (Registro) session.createQuery("from Registro r where r.dato ='"+id+"'").uniqueResult();
   
  } catch (Exception e) {
   e.printStackTrace();
  }
  return Result;
  }
  
  public List getDatoAlarmaxIdSensor(int id){
      //devuelve el dato y el registro de la alarma 
      List<Dato> ListAlarma = null;
  try {
   org.hibernate.Transaction tx = session.beginTransaction();
   Query q = session.createQuery("select d from Alarma a, Dato d  where d.idDato =  a.idDato and a.sensor ='"+id+"'");
   q.setMaxResults(100);
   q.setFirstResult(100);
   ListAlarma = (List<Dato>) q.list();

  } catch (Exception e) {
   e.printStackTrace();
  }
  return ListAlarma;      
  }
  
  public List getRegistroAlarmaxIdSensor(int id){
      //devuelve el dato y el registro de la alarma 
      List<Registro> ListAlarma = null;
  try {
   org.hibernate.Transaction tx = session.beginTransaction();
   Query q = session.createQuery("select r from Alarma a, Registro r  where r.dato =  a.idDato and a.sensor ='"+id+"'");
   q.setMaxResults(100);
   q.setFirstResult(100);
   ListAlarma = (List<Registro>) q.list();

  } catch (Exception e) {
   e.printStackTrace();
  }
  return ListAlarma;      
  }
  
  public List getListMicroXIdEst(int idEst){
      List<Micro> ListMicro = null;
  try {
   org.hibernate.Transaction tx = session.beginTransaction();
   Query q = session.createQuery(" select m.id from Micro m where m.estacion ='"+idEst+"'");
      ListMicro = (List<Micro>) q.list();
      //tx.commit();
  } catch (Exception e) {
   e.printStackTrace();
  }
  return ListMicro;
  
  }
  
  public String getmaxid(){  //max id de la tabla DATO
      String in="";
      Query q;
   List a;
      org.hibernate.Transaction tx = session.beginTransaction();
   q = session.createQuery("select max(d.id) from Dato d"); 
     a = q.list();
     in = String.valueOf(a.get(0));
         
     return in;
     
  }
  
}
