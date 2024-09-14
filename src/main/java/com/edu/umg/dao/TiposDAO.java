/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.umg.dao;

import com.edu.umg.entities.Tipos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ian
 */
public class TiposDAO {
    private SessionFactory sessionFactory;
    
     public TiposDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
     public List<Tipos> getAllTipos() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Tipos> tiposList = session.createQuery("from Tipos", Tipos.class).list();
        session.getTransaction().commit();
        session.close();

        return tiposList;
    }
     
      public void updateTipos(Tipos tipo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(tipo);
        transaction.commit();
        session.close();
    }
     
     
      public Tipos getTIposById(Long id) {
        Session session = sessionFactory.openSession();
        Tipos tipos = session.get(Tipos.class, id);
        session.close();
        return tipos;
    }
     
}
