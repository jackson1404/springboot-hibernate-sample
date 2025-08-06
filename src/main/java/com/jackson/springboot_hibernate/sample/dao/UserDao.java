package com.jackson.springboot_hibernate.sample.dao;

import com.jackson.springboot_hibernate.sample.model.UserEntity;
import com.jackson.springboot_hibernate.sample.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDao {

    public void save(UserEntity UserEntity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(UserEntity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public UserEntity get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(UserEntity.class, id);
        }
    }

    public List<UserEntity> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from UserEntity", UserEntity.class).list();
        }
    }

    public void update(UserEntity UserEntity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(UserEntity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            UserEntity UserEntity = session.get(UserEntity.class, id);
            if (UserEntity != null) {
                session.remove(UserEntity);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}