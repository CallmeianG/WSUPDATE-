/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.umg.dao;

import com.edu.umg.entities.Prestamos;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ian
 */
public class PrestamosDAO {
    
    private SessionFactory sessionFactory;
     
     public PrestamosDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
   
      public List<Prestamos> getAllPrestamosList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         List<Prestamos> prestamosList = session.createQuery(
        "SELECT p FROM Prestamos p " +
        "JOIN FETCH p.estudiante " +
        "JOIN FETCH p.libro", Prestamos.class).list();
         
          session.getTransaction().commit();
          session.close();
        
        return prestamosList;
    }
       
       
       public Prestamos getPrestamosById(Long id) {
        Session session = sessionFactory.openSession();
        Prestamos prestamos = session.get(Prestamos.class, id);
        session.close();
        return prestamos;
    }
       
      public void updateAutores(Prestamos prestamos) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(prestamos);
        transaction.commit();
        session.close();
    }
     
}
