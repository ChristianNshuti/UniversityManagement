package service;

import model.Student;
import dao.StudentDAO;

import java.util.*;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public void saveStudent(String name,String email,String level) {
        Student student = new Student(name,email,level);
        studentDAO.saveStudent(student);
    }

    public Student getStudentById(Long id) {
        Student student = studentDAO.getStudentById(id);
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        return students;
    }

    public void deleteStudent(Long id) {
        studentDAO.deleteStudent(id);
    }


}