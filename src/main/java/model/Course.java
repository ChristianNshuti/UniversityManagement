package model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String instructorName;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course() {}

    public Course(String title,String instructorName) {
        this.title = title;
        this.instructorName = instructorName;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
}

