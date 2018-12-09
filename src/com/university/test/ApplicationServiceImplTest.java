package com.university.test;

import com.university.app.domain.Student;
import com.university.app.enums.SwapLettersResult;
import com.university.app.repository.StudentRepository;
import com.university.app.service.ApplicationServiceImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceImplTest extends TestCase {

    @Mock
    private StudentRepository mRepository;

    @InjectMocks
    private ApplicationServiceImpl mService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @org.junit.Test
    public void testDeleteStudentsByFirstLetterInName_NobodyDeleted() {
        List<Student> listOfStudents = new ArrayList<Student>();

        Student student1 = new Student("FirstName1", "LastName1", 1, 20);
        Student student2 = new Student("FirstName2", "LastName2", 2, 20);
        Student student3 = new Student("FirstName3", "LastName3", 3, 20);
        Student student4 = new Student("FirstName4", "LastName4", 4, 20);
        Student student5 = new Student("FirstName5", "LastName5", 5, 20);
        Student student6 = new Student("FirstName6", "LastName6", 6, 20);
        Student student7 = new Student("FirstName7", "LastName7", 7, 20);
        Student student8 = new Student("FirstName8", "LastName8", 8, 20);
        Student student9 = new Student("FirstName9", "LastName9", 9, 20);
        Student student10 = new Student("FirstName10", "LastName10", 10, 20);

        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);
        listOfStudents.add(student5);
        listOfStudents.add(student6);
        listOfStudents.add(student7);
        listOfStudents.add(student8);
        listOfStudents.add(student9);
        listOfStudents.add(student10);

        Mockito.when(mRepository.getAllStudents()).thenReturn(listOfStudents);

        List<Student> result = mService.deleteStudentsByFirstLetterInName('a');

        assertTrue(result.equals(listOfStudents));
    }

    @org.junit.Test
    public void testDeleteStudentsByFirstLetterInName_OneStudentDeleted() {
        List<Student> listOfStudents = new ArrayList<Student>();

        Student student1 = new Student("FirstName1", "LastName1", 1, 20);
        Student student2 = new Student("FirstName2", "LastName2", 2, 20);
        Student student3 = new Student("DeleteName3", "LastName3", 3, 20);
        Student student4 = new Student("FirstName4", "LastName4", 4, 20);
        Student student5 = new Student("FirstName5", "LastName5", 5, 20);
        Student student6 = new Student("FirstName6", "LastName6", 6, 20);
        Student student7 = new Student("FirstName7", "LastName7", 7, 20);
        Student student8 = new Student("FirstName8", "LastName8", 8, 20);
        Student student9 = new Student("FirstName9", "LastName9", 9, 20);
        Student student10 = new Student("FirstName10", "LastName10", 10, 20);

        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);
        listOfStudents.add(student5);
        listOfStudents.add(student6);
        listOfStudents.add(student7);
        listOfStudents.add(student8);
        listOfStudents.add(student9);
        listOfStudents.add(student10);

        Mockito.when(mRepository.getAllStudents()).thenReturn(listOfStudents);

        List<Student> result = mService.deleteStudentsByFirstLetterInName('D');

        assertFalse(result.contains(student3));
    }

    @org.junit.Test
    public void testDeleteStudentsByFirstLetterInName_AllStudentsDeleted() {
        List<Student> listOfStudents = new ArrayList<Student>();

        Student student1 = new Student("DeleteName1", "LastName1", 1, 20);
        Student student2 = new Student("DeleteName2", "LastName2", 2, 20);
        Student student3 = new Student("DeleteName3", "LastName3", 3, 20);
        Student student4 = new Student("DeleteName4", "LastName4", 4, 20);
        Student student5 = new Student("DeleteName5", "LastName5", 5, 20);
        Student student6 = new Student("DeleteName6", "LastName6", 6, 20);
        Student student7 = new Student("DeleteName7", "LastName7", 7, 20);
        Student student8 = new Student("DeleteName8", "LastName8", 8, 20);
        Student student9 = new Student("DeleteName9", "LastName9", 9, 20);
        Student student10 = new Student("DeleteName10", "LastName10", 10, 20);

        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);
        listOfStudents.add(student5);
        listOfStudents.add(student6);
        listOfStudents.add(student7);
        listOfStudents.add(student8);
        listOfStudents.add(student9);
        listOfStudents.add(student10);

        Mockito.when(mRepository.getAllStudents()).thenReturn(listOfStudents);

        List<Student> result = mService.deleteStudentsByFirstLetterInName('D');

        assertTrue(result.size() == 0);
    }

    @org.junit.Test
    public void testSwapAllSymbolsXOnSymbolYInStudentName_StudentNotFound() {
        List<Student> listOfStudents = new ArrayList<Student>();

        Student student1 = new Student("DeleteName1", "LastName1", 1, 20);
        Student student2 = new Student("DeleteName2", "LastName2", 2, 20);
        Student student3 = new Student("DeleteName3", "LastName3", 3, 20);
        Student student4 = new Student("DeleteName4", "LastName4", 4, 20);
        Student student5 = new Student("DeleteName5", "LastName5", 5, 20);
        Student student6 = new Student("DeleteName6", "LastName6", 6, 20);
        Student student7 = new Student("DeleteName7", "LastName7", 7, 20);
        Student student8 = new Student("DeleteName8", "LastName8", 8, 20);
        Student student9 = new Student("DeleteName9", "LastName9", 9, 20);
        Student student10 = new Student("Axel", "LastName10", 10, 20);

        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);
        listOfStudents.add(student5);
        listOfStudents.add(student6);
        listOfStudents.add(student7);
        listOfStudents.add(student8);
        listOfStudents.add(student9);
        listOfStudents.add(student10);

        Mockito.when(mRepository.getAllStudents()).thenReturn(listOfStudents);
        Mockito.when(mRepository.getStudent(12)).thenReturn(null);

        SwapLettersResult result = mService.swapAllSymbolsXOnSymbolYInStudentName(12, 'x', 'y');

        assertTrue(result == SwapLettersResult.StudentNotFound);
    }

    @org.junit.Test
    public void testSwapAllSymbolsXOnSymbolYInStudentName_SwapCorrect() {
        List<Student> listOfStudents = new ArrayList<Student>();

        Student student1 = new Student("DeleteName1", "LastName1", 1, 20);
        Student student2 = new Student("DeleteName2", "LastName2", 2, 20);
        Student student3 = new Student("DeleteName3", "LastName3", 3, 20);
        Student student4 = new Student("DeleteName4", "LastName4", 4, 20);
        Student student5 = new Student("DeleteName5", "LastName5", 5, 20);
        Student student6 = new Student("DeleteName6", "LastName6", 6, 20);
        Student student7 = new Student("DeleteName7", "LastName7", 7, 20);
        Student student8 = new Student("DeleteName8", "LastName8", 8, 20);
        Student student9 = new Student("DeleteName9", "LastName9", 9, 20);
        Student student10 = new Student("Acxel", "LastName10", 10, 20);

        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);
        listOfStudents.add(student5);
        listOfStudents.add(student6);
        listOfStudents.add(student7);
        listOfStudents.add(student8);
        listOfStudents.add(student9);
        listOfStudents.add(student10);

        Mockito.when(mRepository.getAllStudents()).thenReturn(listOfStudents);
        Mockito.when(mRepository.getStudent(10)).thenReturn(student10);

        SwapLettersResult result = mService.swapAllSymbolsXOnSymbolYInStudentName(10, 'A', 'E');

        assertTrue(result == SwapLettersResult.SwapCorrect);
    }

    @org.junit.Test
    public void testSwapAllSymbolsXOnSymbolYInStudentName_NotSwapped() {
        List<Student> listOfStudents = new ArrayList<Student>();

        Student student1 = new Student("DeleteName1", "LastName1", 1, 20);
        Student student2 = new Student("DeleteName2", "LastName2", 2, 20);
        Student student3 = new Student("DeleteName3", "LastName3", 3, 20);
        Student student4 = new Student("DeleteName4", "LastName4", 4, 20);
        Student student5 = new Student("DeleteName5", "LastName5", 5, 20);
        Student student6 = new Student("DeleteName6", "LastName6", 6, 20);
        Student student7 = new Student("DeleteName7", "LastName7", 7, 20);
        Student student8 = new Student("DeleteName8", "LastName8", 8, 20);
        Student student9 = new Student("DeleteName9", "LastName9", 9, 20);
        Student student10 = new Student("Acxel", "LastName10", 10, 20);

        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);
        listOfStudents.add(student5);
        listOfStudents.add(student6);
        listOfStudents.add(student7);
        listOfStudents.add(student8);
        listOfStudents.add(student9);
        listOfStudents.add(student10);

        Mockito.when(mRepository.getAllStudents()).thenReturn(listOfStudents);
        Mockito.when(mRepository.getStudent(10)).thenReturn(student10);

        SwapLettersResult result = mService.swapAllSymbolsXOnSymbolYInStudentName(10, 'w', 'c');

        assertTrue(result == SwapLettersResult.NotSwapped);
    }

    public static Test suite() {
        return new TestSuite(ApplicationServiceImplTest.class);
    }
}
