package dao;

import model.Instructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.*;

public class InstructorDAO {

    public void saveInstructor(Instructor instructor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(instructor);
        tx.commit();
        session.close();
    }

    public List<Instructor> getAllInstructors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Instructor> instructors = session.createQuery("from Instructor",Instructor.class).list();
        session.close();
        return instructors;
    }

    public Instructor getInstructorById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Instructor instructor = session.get(Instructor.class,id);
        return instructor;
    }

    public void deleteInstructor(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Instructor instructor = session.get(Instructor.class,id);
        if (instructor != null) {
            session.remove(instructor);
        }
        tx.commit();
        session.close();
    }

}