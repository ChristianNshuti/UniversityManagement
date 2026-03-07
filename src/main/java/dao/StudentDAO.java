package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class StudentDAO {

    public void saveStudent(Student student) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(student);

        tx.commit();
        session.close();
    }


    public Student getStudentById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student student = session.get(Student.class,id);

        session.close();
        return student;
    }

    public List<Student> getAllStudents() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Student> students = session.createQuery("from Student", Student.class).list();

        session.close();
        return students;
    }

    public void deleteStudent(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class,id);

        if(student != null) {
            session.remove(student);
        }

        tx.commit();
        session.close();
    }
}