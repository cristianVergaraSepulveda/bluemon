/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DatoActual;
import Modelo.HibernateUtil;
import Modelo.Sensor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author athanatos
 */
public class SensorDAO extends HibernateUtil{

    Session session = null;

    public SensorDAO() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getListaDatoActual() {
        List<DatoActual> ListEstacion = null;
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //query->from Actor as actor where actor.actorId in (select filmActor.actor.actorId from FilmActor as filmActor where filmActor.film.filmId='" + microId + "')
            Query q = session.createQuery("from DatoActual");
            ListEstacion = (List<DatoActual>) q.list();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        tx.commit();
        return ListEstacion;

    }
}
