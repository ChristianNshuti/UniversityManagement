package dao;

import model.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class CourseDAO {

    public void saveCourse(Course course) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(course);

        tx.commit();
        session.close();
    }

    public Course getCourseById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Course course = session.get(Course.class,id);

        session.close();
        return course;
    }

    public List<Course> getAllCourses() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Course> courses = session.createQuery(
                "select distinct c from Course c " +
                        "join fetch c.instructor " +
                        "left join fetch c.enrollments",
                Course.class
        ).list();

        session.close();
        return courses;
    }

    public void deleteCourse(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Course course = session.get(Course.class,id);
        if(course != null) {
            session.remove(course);
        }

        tx.commit();
        session.close();
    }


}