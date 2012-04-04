/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author athanatos
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
              //  sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
  //   sessionFactory = new Configuration().configure(new File("/src/java/hibernate/hibernateMon.cfg.xml")).buildSessionFactory();
     
     String ruta=Thread.currentThread().getContextClassLoader().getResource("hibernate.cfg.xml").toString();
     ruta=ruta.substring(5,ruta.length());
     File hcfg=new File(ruta);
     sessionFactory=new Configuration().configure(hcfg).buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
