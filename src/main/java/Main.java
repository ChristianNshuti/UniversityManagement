
import model.Course;
import model.Enrollment;
import model.Student;
import service.CourseService;
import service.StudentService;
import service.EnrollmentService;
import service.InstructorService;
import model.Instructor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService();
        EnrollmentService enrollmentService = new EnrollmentService();
        InstructorService instructorService = new InstructorService();

        String studentName = "christian";
        String studentEmail = "chrisnshuti943@gmail.com";
        String level = "Level 5";
        String instructorName = "Bosco";
        String instructorEmail = "bosco@gmail.com";
        String department = "Math";
        Student student = new Student(studentName,studentEmail,level);
        studentService.saveStudent(student);
        Instructor instructor = new Instructor(instructorName,instructorEmail,department);
        instructorService.saveInstructor(instructor);
        String title = "Mathematics";
        Course course = new Course(title,instructor);
        courseService.saveCourse(course);
        Enrollment enrollment = new Enrollment(student,course);
        enrollmentService.saveEnrollment(enrollment);
        List<Student> allStudents = studentService.getAllStudents();
        System.out.println("All students: ");
        allStudents.forEach(s -> System.out.println(s.getId() + " " + s.getName() +
                " " + s.getEmail() + " " + s.getLevel()));
        List<Course> allCourses = courseService.getAllCourses();
        System.out.println("All courses: ");
        allCourses.forEach(c -> System.out.println(c.getId() + " " + c.getTitle() + " "
        + c.getInstructor().getName() + " " + c.getEnrollments().size()));
        List<Enrollment> allEnrollments = enrollmentService.getAllEnrollments();
        System.out.println("All enrollments: ");
        allEnrollments.forEach(e -> System.out.println(e.getId() + " " + e.getStudent().getName() + " "
        + e.getCourse().getTitle()));
    }
}