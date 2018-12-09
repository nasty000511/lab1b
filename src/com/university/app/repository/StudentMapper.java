package com.university.app.repository;

import com.university.app.domain.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("Id"));
        student.setFirstName(rs.getString("FirstName"));
        student.setSurname(rs.getString("LastName"));
        student.setAge(rs.getInt("Age"));

        return student;
    }
}
