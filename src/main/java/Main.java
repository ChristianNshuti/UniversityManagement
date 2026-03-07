
import model.Course;
import model.Enrollment;
import model.Student;
import service.CourseService;
import service.StudentService;
import service.EnrollmentService;
import model.Instructor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        StudentService studentService = new StudentService();
        EnrollmentService enrollmentService = new EnrollmentService();

        String studentName = "christian";
        String studentEmail = "chrisnshuti943@gmail.com";
        String level = "Level 5";
        String instructorName = "Bosco";
        String instructorEmail = "bosco@gmail.com";
        String department = "Math";
        Student student = new Student(studentName,studentEmail,level);
        studentService.saveStudent(student);
        Instructor instructor = new Instructor(instructorName,instructorEmail,department);
        String title = "Mathematics";
        Course course = new Course(title,instructor);
        courseService.saveCourse(course);
        Enrollment enrollment = new Enrollment(student,course);
        enrollmentService.saveEnrollment(enrollment);
        List<Student> allStudents = studentService.getAllStudents();
        allStudents.forEach(s -> System.out.println(s.getId() + " " + s.getName() +
                " " + s.getEmail() + " " + s.getLevel()));
        List<Course> allCourses = courseService.getAllCourses();
        allCourses.forEach(c -> System.out.println(c.getId() + " " + c.getTitle() + " "
        + c.getInstructorName() + " " + c.getEnrollments()));
        List<Enrollment> allEnrollments = enrollmentService.getAllEnrollments();
        allEnrollments.forEach(e -> System.out.println(e.getId() + " " + e.getStudent() + " "
        + e.getCourse()));
    }
}