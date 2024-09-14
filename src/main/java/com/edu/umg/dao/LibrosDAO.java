/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.umg.dao;


import com.edu.umg.entities.Libros;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ian
 */
public class LibrosDAO {
    private SessionFactory sessionFactory;
    
    public LibrosDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public List<Libros> getAllLibros() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Libros> librostesList = session.createQuery("from Libros", Libros.class).list();
        session.getTransaction().commit();
        session.close();

        return librostesList;
    }  
    
    
       public Libros getLibrosById(Long id) {
        Session session = sessionFactory.openSession();
        Libros libros = session.get(Libros.class, id);
        session.close();
        return libros;
    }
       
      public void updateLibros(Libros libros) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(libros);
        transaction.commit();
        session.close();
    }
}
