package com.university.app.repository;

import com.university.app.domain.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentRepository {
    public void create(String name, String surname, Integer age);

    public Student getStudent(Integer id);

    public List<Student> getAllStudents();

    public void delete(Integer id);

    public void delete(Student student);

    public void update(Student student);

}
