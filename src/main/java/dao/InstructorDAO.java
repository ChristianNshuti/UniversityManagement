package dao;

import model.Instructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.*;

public class InstructorDAO {

    public void saveInstructor(Instructor) {
        Session session = HibernateUtil.getSessionFactory().openSession();

    }
}