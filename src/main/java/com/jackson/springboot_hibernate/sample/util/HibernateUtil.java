/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.springboot_hibernate.sample.util;

import com.jackson.springboot_hibernate.sample.model.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil Class.
 * <p>
 * </p>
 *
 * @author
 */
public final class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            config.addAnnotatedClass(UserEntity.class);
            return config.buildSessionFactory(
                    new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties()).build());
        } catch (Throwable ex){
            throw new ExceptionInInitializerError("Session Factory creation failed: " + ex);
        }


    }

    private HibernateUtil(){}

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }


}
