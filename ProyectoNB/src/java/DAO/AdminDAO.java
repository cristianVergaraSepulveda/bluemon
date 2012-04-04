/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author athanatos
 */
import Modelo.Login;
import Modelo.TipoLogin;
import Modelo.HibernateUtil;
import Modelo.Sensor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;

public class AdminDAO {

    private Login log;
    private TipoLogin tlog;
    public List<Login> ListLogin = null;
    Session session = null;

    public AdminDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getLogin() {
        List<Login> LoginList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Login l"); //, TipoLogin t where t.idTipoLogin = l.tipoLogin
            LoginList = (List<Login>) q.list();
            this.ListLogin = LoginList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LoginList;
    }

    public List getMaxMinSensor() {
        List<Sensor> SensorList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Sensor s");
            SensorList = (List<Sensor>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SensorList;
    }

    public boolean setUpdateSensor(int idSensor, int Max, int Min) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Sensor sensor = new Sensor();
        sensor.setIdSensor(idSensor);
        sensor = (Sensor) session.load(Sensor.class, idSensor);
        sensor.setMaxima(Max);
        sensor.setMinima(Min);
        //session.save(sensor);
        session.update(sensor);
        session.flush();
        session.getTransaction().commit();
        return true;
    }
}
