/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.umg.dao;

import com.edu.umg.entities.Autores;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author Ian
 */
public class AutoresDAO {
     private SessionFactory sessionFactory;
     
     public AutoresDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
     
       public List<Autores> getAllAutores() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Autores> autoresList = session.createQuery("from Autores", Autores.class).list();
        session.getTransaction().commit();
        session.close();

        return autoresList;
    }
       
       
       public Autores getAutoresById(Long id) {
        Session session = sessionFactory.openSession();
        Autores autroes = session.get(Autores.class, id);
        session.close();
        return autroes;
    }
       
      public void updateAutores(Autores autores) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(autores);
        transaction.commit();
        session.close();
    }
     
}
