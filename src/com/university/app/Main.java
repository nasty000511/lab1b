package com.university.app;

import com.university.app.config.DatabaseConfig;
import com.university.app.domain.Student;
import com.university.app.repository.StudentRepositoryImpl;
import com.university.app.service.ApplicationServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    private static ApplicationContext context;
    private static ApplicationServiceImpl service;
    private static StudentRepositoryImpl studentRepository;

    private static boolean tableIsNeedToSeed = true;
    private static boolean tableIsNeedToTruncate = true;

    public static void main(String[] args) {
        MainPresenter mainPresenter = new MainPresenter(context, service, studentRepository);

        mainPresenter.initialize();

        if (tableIsNeedToSeed)
            mainPresenter.seedTableStudents();

        mainPresenter.showAllStudents("All students:");

        mainPresenter.task2();
        mainPresenter.task4();

        if (tableIsNeedToTruncate)
            mainPresenter.truncateTableStudents();
    }


}
