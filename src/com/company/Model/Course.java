package com.company.Model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private Person teacher;
    private int maxenrolled;
    private List<Student> enrolledstudents;
    private int credits;

    public Course(String name, Person teacher, int max, int credits){
        this.name = name;
        this.teacher = teacher;
        this.maxenrolled = max;
        this.credits = credits;
        this.enrolledstudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxenrolled() {
        return maxenrolled;
    }

    public void setMaxenrolled(int maxenrolled) {
        this.maxenrolled = maxenrolled;
    }

    public Person getTeacher() {
        return teacher;
    }

    public List<Student> getEnrolledstudents() {
        return enrolledstudents;
    }

    public void addStudent(Student stud) {
            this.enrolledstudents.add(stud);
    }

    public boolean free(){
        return this.maxenrolled > this.enrolledstudents.size();
    }

    public void print(){
        for (Student index: enrolledstudents)
            System.out.println(index);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", maxenrolled=" + maxenrolled +
                ", credits=" + credits +
                '}';
    }
}
