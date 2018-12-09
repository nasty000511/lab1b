package com.university.app;

import com.university.app.config.DatabaseConfig;
import com.university.app.domain.Student;
import com.university.app.repository.StudentRepositoryImpl;
import com.university.app.service.ApplicationServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainPresenter {
    public  String separator = "---------------------------------------------------------";

    private  ApplicationContext context;
    private  ApplicationServiceImpl service;
    private  StudentRepositoryImpl studentRepository;

    public MainPresenter(ApplicationContext context
            , ApplicationServiceImpl service, StudentRepositoryImpl studentRepository) {
        this.context = context;
        this.service = service;
        this.studentRepository = studentRepository;
    }

    public  void initialize() {
        context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        service = context.getBean(ApplicationServiceImpl.class);

        studentRepository = context.getBean(StudentRepositoryImpl.class);
    }

    public  void seedTableStudents() {
        System.out.println(separator);
        System.out.println("Start seedTableStudents...");

        service.seed();
    }

    public  void showAllStudents(String message, List<Student> allStudents) {
        System.out.println(separator);

        System.out.println("\n\n" + message);

        for (Student student : allStudents)
            System.out.println(student + "\n");
    }

    public  void showAllStudents(String message) {
        System.out.println(separator);
        List<Student> allStudents = service.getListOfStudents();

        System.out.println("\n\n" + message);

        for (Student student : allStudents) {
            System.out.println(student + "\n");
        }
    }

    public  void task2() {
        System.out.println(separator);
        System.out.println("Task 2");

        List<Student> allStudents = service.deleteStudentsByFirstLetterInName('J');

        showAllStudents("Students after delete: \n", allStudents);
    }

    public  void task4() {
        System.out.println(separator);
        System.out.println("Task 4");

        int id = service.getFirstStudentWithSymbolXInName('J');

        if (id != -1) {
            service.swapAllSymbolsXOnSymbolYInStudentName(id, 'J', 'C');
            Student student = service.getStudent(id);
            System.out.println("\nStudent after swap: ");
            System.out.println(student);
        }
    }

    public  void truncateTableStudents() {
        System.out.println(separator);
        System.out.println("Start truncateTableStudents...");

        studentRepository.truncateDb();
    }

    /*
    public  void showAllStudents(String message) {
        System.out.println(separator);
        List<Student> allStudents = service.getListOfStudents();

        System.out.println("\n\n" + message);

        for (Student student : allStudents) {
            System.out.println(student + "\n");
        }
    }
    */
}
