package com.university.app.service;

import com.university.app.domain.Student;
import com.university.app.enums.SwapLettersResult;

import java.util.List;

public interface ApplicationService {
    // Default
    public List getListOfStudents();

    public Student getStudent(int studentId);

    // Task 2
    public List deleteStudentsByFirstLetterInName(char letter);

    // Task 4
    public SwapLettersResult swapAllSymbolsXOnSymbolYInStudentName(int studentId, char x, char y);

    public int getFirstStudentWithSymbolXInName(char x);

    public void seed();
}
