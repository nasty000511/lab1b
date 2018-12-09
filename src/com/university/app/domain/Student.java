package com.university.app.domain;

public class Student {
    private Integer Id;
    private String FirstName;
    private String LastName;
    private Integer Age;

    public Student() {

    }

    public Student(String firstName, String surname, Integer id ,Integer age) {
        this.Id = id;
        this.FirstName = firstName;
        this.LastName = surname;
        this.Age = age;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer mId) {
        this.Id = mId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String mName) {
        this.FirstName = mName;
    }

    public String getSurname() {
        return LastName;
    }

    public void setSurname(String mSurname) {
        this.LastName = mSurname;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer mAge) {
        this.Age = mAge;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Student ID = ");
        res.append(this.Id);
        res.append("\nFirstName = ");
        res.append(this.FirstName);
        res.append("\nSurname = ");
        res.append(this.LastName);
        res.append("\nAge = ");
        res.append(this.Age);
        return res.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object != null) {
            Student student = (Student) object;
            if (!this.Age.equals(student.getAge()) ||
                    !this.FirstName.equals(student.getFirstName()) ||
                    !this.LastName.equals(student.getSurname()) ||
                    !this.Id.equals(student.getId())) return false;
            return true;
        }
        return false;
    }
}