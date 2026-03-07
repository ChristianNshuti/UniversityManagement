package service;

import model.Course;
import model.Instructor;
import dao.CourseDAO;

import java.util.*;

public class CourseService {

    private final CourseDAO courseDAO = new CourseDAO();

    public void saveCourse(String title,Instructor instructor) {
        Course course = new Course(title,instructor);
        courseDAO.saveCourse(course);
    }

    public Course getCourseById(Long id) {
        return courseDAO.getCourseById(id);
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    public void deleteCourse(Long id) {
        courseDAO.deleteCourse(id);
    }
}