package service;

import model.Student;
import dao.StudentDAO;

import java.util.*;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public Student getStudentById(Long id) {
        return studentDAO.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void deleteStudent(Long id) {
        studentDAO.deleteStudent(id);
    }


}