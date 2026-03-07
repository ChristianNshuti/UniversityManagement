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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course() {}

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}

