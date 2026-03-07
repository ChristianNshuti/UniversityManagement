package service;

import model.Enrollment;
import model.Course;
import model.Student;
import dao.EnrollmentDAO;

import java.util.*;

public class EnrollmentService {

    private final EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    public void saveEnrollment(Enrollment enrollment) {
        enrollmentDAO.saveEnrollment(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentDAO.getAllEnrollments();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentDAO.getEnrollmentById(id);
    }

    public void deleteEnrollment(Long id) {
        enrollmentDAO.deleteEnrollment(id);
    }

}