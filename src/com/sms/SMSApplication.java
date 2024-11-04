package com.sms;

import com.sms.model.Student;
import com.sms.model.Course;
import com.sms.model.Enrollment;
import com.sms.service.StudentService;
import com.sms.service.CourseService;
import com.sms.service.EnrollmentService;

import java.util.List;
import java.util.Scanner;

public class SMSApplication {
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Course");
            System.out.println("4. View All Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> addCourse();
                case 4 -> viewAllCourses();
                case 5 -> enrollStudentInCourse();
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        Student student = new Student(0, name, dob, gender);
        studentService.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();
        System.out.println("\n--- Students List ---");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void addCourse() {
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Course Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Course course = new Course(0, courseName, description, credits);
        courseService.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private static void viewAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        System.out.println("\n--- Courses List ---");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void enrollStudentInCourse() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Enrollment enrollment = new Enrollment(0, studentId, courseId);
        enrollmentService.enrollStudent(enrollment);
        System.out.println("Student enrolled in course successfully.");
    }
}

