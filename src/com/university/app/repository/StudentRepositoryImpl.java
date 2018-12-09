package com.university.app.repository;

import com.university.app.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.SecureRandom;
import java.util.List;

@Repository
@Qualifier("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private JdbcTemplate mJdbcTemplateObject;

    public void create(String name, String surname, Integer age) {
        String SQL = "insert into Students (FirstName, LastName, Age) values (?, ?, ?)";
        mJdbcTemplateObject.update(SQL, name, surname, age/*, 1*/);
    }

    public Student getStudent(Integer id) {
        String SQL = "select * from Students where id = ?";
        Student student = mJdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new StudentMapper());

        return student;
    }

    public List<Student> getAllStudents() {
        String SQL = "select * from Students";
        List<Student> students = mJdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }

    public void delete(Integer id) {
        String SQL = "delete from Students where id = ?";
        mJdbcTemplateObject.update(SQL, id);
    }

    public void delete(Student student) {
        String SQL = "delete from Students where id = ?";
        mJdbcTemplateObject.update(SQL, student.getId());
    }

    public void update(Student student) {
        String SQL = "update Students set FirstName = ?, LastName = ?, Age = ? where Id = ?";
        mJdbcTemplateObject.update(SQL, student.getFirstName(), student.getSurname(), student.getAge(), student.getId());
    }



    public void truncateDb(){
        // TRUNCATE TABLE table_name
        mJdbcTemplateObject.update("TRUNCATE TABLE Students");
    }
}
