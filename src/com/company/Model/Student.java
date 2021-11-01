package com.company.Model;

import com.company.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int next_id = 10000;
    private long studentid;
    private int credits;
    private List<Course> enrolledcourse;

    public Student(String name, String vorname){
        super(name, vorname);
        this.studentid = ++next_id;
        this.credits = 0;
        this.enrolledcourse = new ArrayList<>();
    }

    public int getCredits() {
        return credits;
    }

    public long getStudentid() {
        return studentid;
    }

    public void addCourse(Course c){
        this.enrolledcourse.add(c);
        this.credits += c.getCredits();
    }

    public void removeCourse(Course c){
        this.enrolledcourse.remove(c);
        this.credits -= c.getCredits();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid= " + studentid + "  studentname= " + this.getName() + " " + this.getVorname() +
                '}';
    }
}
