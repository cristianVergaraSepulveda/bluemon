

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
    public void  CreateandStoreLogin(TipoLogin tipoLogin, String login ){
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Login login2 = new Login();
        login2.setLogin(null);
        login2.setPassword(null);
        login2.setTipoLogin(tipoLogin);        
        session.save(login);
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
       session.close();
        return tp2;
    }
    
    
    
}
