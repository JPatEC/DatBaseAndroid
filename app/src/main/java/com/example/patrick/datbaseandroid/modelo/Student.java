package com.example.patrick.datbaseandroid.modelo;

/**
 * Created by Patrick on 7/1/2018.
 */

public class Student {
    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME = "Student";
    // Labels Table Columns names
    public static final String KEY_StudentId = "StudentId";
    public static final String KEY_Name = "Name";
    public static final String KEY_SurName = "Surname";
    public static final String KEY_Description = "Description";

    private String Studentid;
    private String name;
    private String surname;
    private String description;

    public String getStudentid() {
        return Studentid;
    }

    public void setStudentid(String studentid) {
        Studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
