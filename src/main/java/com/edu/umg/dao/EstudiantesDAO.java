/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.umg.dao;


import com.edu.umg.entities.Estudiantes;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ian
 */
public class EstudiantesDAO {
     private SessionFactory sessionFactory;
     
      public EstudiantesDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
      
    public List<Estudiantes> getAllEstudiantes() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Estudiantes> estudiantesList = session.createQuery("from Estudiantes", Estudiantes.class).list();
        session.getTransaction().commit();
        session.close();

        return estudiantesList;
    }  
      public Estudiantes getEstudiantesById(Long id) {
        Session session = sessionFactory.openSession();
        Estudiantes estudiantes = session.get(Estudiantes.class, id);
        session.close();
        return estudiantes;
    }
       
      public void updateAutores(Estudiantes estudiantes) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(estudiantes);
        transaction.commit();
        session.close();
    }
    
}
