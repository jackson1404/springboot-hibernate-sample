/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.springboot_hibernate.util;

import com.jackson.springboot_hibernate.model.UserEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

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
