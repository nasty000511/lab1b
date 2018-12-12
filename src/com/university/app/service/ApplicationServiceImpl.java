package com.university.app.service;

import com.university.app.domain.enums.SwapLettersResult;
import com.university.app.helpers.StudentNameValidator;
import com.university.app.repository.StudentRepository;
import com.university.app.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private StudentRepository mStudentRepository;

    public void seed(){
        String[] names = new String[]{"Jack", "Sem", "Gregor", "Vasya", "Ivan", "Bella", "Anna"};
        String[] surnames = new String[]{"White", "Black", "Yellow", "Pink", "Grey", "Green", "Purple"};
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 1; i < 3; i++) {
            mStudentRepository.create("Jack" + ((char)(62 + i)), "Black" + ((char)(64 + i)), 30 + i);
            mStudentRepository.create("BJackJack" + ((char)(62 + i)), "Black" + ((char)(64 + i)), 30 + i);
            mStudentRepository.create(names[secureRandom.nextInt(names.length)]
                    ,  surnames[secureRandom.nextInt(names.length)]
                    , i * secureRandom.nextInt(7));
        }
    }

    // Deffault
    public List getListOfStudents() {
        return mStudentRepository.getAllStudents();
    }

    // Task 2
    @Override
    public List deleteStudentsByFirstLetterInName(char letter) {
        List<Student> allStudents = mStudentRepository.getAllStudents();

        for (int i = 0; i < allStudents.size();) {
            Student student = allStudents.get(i);

            if (student != null && StudentNameValidator.isFirstLetterInStringEqualToX(student.getFirstName(), letter)) {
                // Try to delete student
                mStudentRepository.delete(student);
                allStudents.remove(student);
            } else {
                ++i;
            }
        }

        return allStudents;
    }

    // Task 4
    @Override
    public SwapLettersResult swapAllSymbolsXOnSymbolYInStudentName(int studentId, char x, char y) {
        // Find student
        Student student = mStudentRepository.getStudent(studentId);

        // Student validation
        if (student == null) return SwapLettersResult.StudentNotFound;

        String studentNameWithoutSwap = student.getFirstName();

        // Try to swap letters
        try {
            char[] studentNameChars = student.getFirstName().toCharArray();

            for (int i = 0; i < studentNameChars.length; i++) {
                if (studentNameChars[i] == x) {
                    studentNameChars[i] = y;
                }
            }

            // Set student name
            student.setFirstName(new String(studentNameChars));

            // Update Student
            mStudentRepository.update(student);
        } catch (Exception ex) {
            ex.printStackTrace();
            return SwapLettersResult.UnknownError;
        }

        return !student.getFirstName().equals(studentNameWithoutSwap)
                ? SwapLettersResult.SwapCorrect : SwapLettersResult.NotSwapped;
    }

    // For task 4
    @Override
    public int getFirstStudentWithSymbolXInName(char x){
        List<Student> allStudents = mStudentRepository.getAllStudents();

        for (Student student : allStudents)
            if (student.getFirstName().contains(String.valueOf(x)))
                return student.getId();

        return -1;
    }

    @Override
    public Student getStudent(int studentId) {
        return mStudentRepository.getStudent(studentId);
    }
}