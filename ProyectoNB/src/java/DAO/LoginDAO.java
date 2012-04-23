

/**
 *
 * @author athanatos
 */
package DAO;

import Modelo.HibernateUtil;
import Modelo.Login;
import Modelo.TipoLogin;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author athanatos
 */
public class LoginDAO extends HibernateUtil{
    
                
    
    Session session = null;
    public LoginDAO(){
    this.session = HibernateUtil.getSessionFactory().getCurrentSession();    
    }
    
    public List getLogin(){
     List<Login> LoginList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Login");
            LoginList = (List<Login>) q.list();
            TipoLogin tpl = new TipoLogin();
            
        }
        catch (Exception e) {
            e.printStackTrace();
            }
        return LoginList;
    }
    
    // crear y guardar 
    public void  CreateandStoreLogin(TipoLogin tipoLogin, String login, String pass ){
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Login login2 = new Login();
        login2.setLogin(login);
        login2.setPassword(pass);
        login2.setTipoLogin(tipoLogin);        
        session.save(login2);
        session.getTransaction().commit();
    }
    
    public Login getLoginxId(long id){
        //session s= HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        return (Login) session.get(Login.class, id);        
    }
    
    public TipoLogin getTipoLoginxID(int id){
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
     session.beginTransaction();
        Login login2 = new Login();
        login2.setIdLogin(id);
        
       Login login3 =(Login) session.load(Login.class, login2.getIdLogin());
       
       TipoLogin tp2 = login3.getTipoLogin();
       session.getTransaction().commit();
      
       return tp2;
    }
    
    public TipoLogin getTipoLoginxIDTipo(int idTipo){
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
     session.beginTransaction();
        TipoLogin TLog = new TipoLogin();
        TLog.setIdTipoLogin(idTipo);
        
       TipoLogin Tlog2 =(TipoLogin) session.get(TipoLogin.class,new Integer(idTipo));
       session.getTransaction().commit();
       return Tlog2;        
    }
    
    public List getListTipoLogin(){
    List<TipoLogin> tipologin = null;
    org.hibernate.Transaction tx = null;
  try {
   tx = session.beginTransaction();
   //query->from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + microId + "')
   Query q = session.createQuery("from TipoLogin");
   tipologin = (List<TipoLogin>) q.list();
  
  } catch (Exception e) {
   e.printStackTrace();
   tx.rollback();
  }
   tx.commit();
    return tipologin;
    }
    //crear login 
    public void  createLogin(TipoLogin tipoLogin, String login, String Pass){
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Login login2 = new Login();
        login2.setLogin(login);
        login2.setPassword(Pass);
        login2.setTipoLogin(tipoLogin);        
        session.save(login2);
        session.getTransaction().commit();
    }
    
    
}
