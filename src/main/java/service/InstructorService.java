package service;

import model.Instructor;
import dao.InstructorDAO;

import java.util.*;

public class InstructorService {

    private final InstructorDAO instructorDAO = new InstructorDAO();

    public void saveInstructor(Instructor instructor) {
        instructorDAO.saveInstructor(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorDAO.getAllInstructors();
    }

    public Instructor getInstructorById(Long id) {
        return instructorDAO.getInstructorById(id);
    }
}