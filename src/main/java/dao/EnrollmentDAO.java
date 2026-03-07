package dao;

import model.Enrollment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class EnrollmentDAO {

    public void saveEnrollment(Enrollment enrollment) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(enrollment);
        tx.commit();
        session.close();
    }

    public List<Enrollment> getAllEnrollments() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Enrollment> enrollments = session.createQuery("from Enrollment",Enrollment.class);
        session.close();
        return enrollments;
    }

    public Enrollment getEnrollmentById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Enrollment enrollment = session.get(Enrollment.class,id);
        session.close();
        return enrollment;
    }

    public void deleteEnrollment(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Enrollment enrollment = session.get(Enrollment.class,id);
        if(enrollment != null) {
            session.remove(enrollment);
        }
        tx.commit();
        session.close();
    }
}