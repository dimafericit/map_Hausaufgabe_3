package com.company;

import com.company.Model.Course;
import com.company.Model.Student;
import com.company.Repository.CourseRepository;
import com.company.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;


public class RegistrationSystem {

    private StudentRepository studenten;
    private CourseRepository course;

    public RegistrationSystem(){
        studenten = new StudentRepository();
        course = new CourseRepository();
    }

    public void addStudent(Student stud){
        studenten.create(stud);
    }

    public void addCourse(Course curs){
        course.create(curs);
    }

    public CourseRepository getAllCourse(){
        return this.course;
    }

    public Course getcoursebyindex(int index){
        return course.getAll().get(index);
    }

    public StudentRepository getAllStudents(){
       return this.studenten;
    }


    public boolean register(Course curs, Student stud){
        if (curs.free() && (stud.getCredits() + curs.getCredits() <= 30)){
            curs.addStudent(stud);
            stud.addCourse(curs);
            return true;
        }
        return false;
    }

    public List<Student> retrieveStudentsEnrolledForACourse(Course curs){
        return curs.getEnrolledstudents();
    }

    public List<Course> retrieveCoursesWithFreePlaces(){
        List<Course> freeCourses = new ArrayList<>();
        for (Course index : this.course.getAll())
            if (index.free()) {
                freeCourses.add(index);
            }
        return freeCourses;
    }


}
