package com.company;

import com.company.Model.Course;
import com.company.Model.Person;
import com.company.Model.Student;
import com.company.Repository.CourseRepository;
import com.company.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {

    private StudentRepository studenten;
    private CourseRepository course;

    /**
     * Constructor
     * initializes two repos (for Students and Courses)
     */
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


    /**
     * makes a connection between a course and a student, if possible
     * @param curs Course object
     * @param stud Student object
     * @return true, if the student got registered
     *         false, if the course is full or the student dosen't have enough credits
     */
    public boolean register(Course curs, Student stud){
        if (curs.free() && (stud.getCredits() + curs.getCredits() <= 30)){
            curs.addStudent(stud);
            stud.addCourse(curs);
            return true;
        }
        return false;
    }

    /**
     * @param curs Course object
     * @return list of students registered for a specific course or empty list if the
     * course dosen't exist
     */
    public List<Student> retrieveStudentsEnrolledForACourse(Course curs){
        for (Course index : course.getAll())
            if (index == curs){
                return index.getEnrolledstudents();
            }
        return new ArrayList<>();
    }

    /**
     * @return al courses with free places
     */
    public List<Course> retrieveCoursesWithFreePlaces(){
        List<Course> freeCourses = new ArrayList<>();
        for (Course index : this.course.getAll())
            if (index.free()) {
                freeCourses.add(index);
            }
        return freeCourses;
    }

    /**
     * @param teacher Teacher object
     * @param courseToDelete Course object the user wants to delete
     * @return true,
     */
    public boolean deleteCourse(Person teacher, Course courseToDelete){
        if (courseToDelete.getTeacher() == teacher) {
            for (Student student :  courseToDelete.getEnrolledstudents()){
                student.removeCourse(courseToDelete);
            }
            course.delete(courseToDelete);
            return true;
        }
        return false;
    }

    /**
     * switchcredit is used to update the course number of credits
     * the credit attribute in student will be updated aswell or will be deleted
     * if the student can't handle the new credits
     * @param newcredits new number of credits
     * @param curs Course object
     * @return false, if the new credit is equal to the old one
     *          true, otherwise
     */
    public boolean switchcredit(int newcredits, Course curs){
        if (curs.getCredits() == newcredits){
            return false;
        }
        for (Student student : this.studenten.getAll()){
            if (student.getEnrolledcourse().contains(curs)){
                if ((student.getCredits() - curs.getCredits() + newcredits) > 30){
                    student.removeCourse(curs);
                }
                else
                    student.setCredits(student.getCredits() - curs.getCredits() + newcredits);
            }
        }
        curs.setCredits(newcredits);
        return true;
    }

}
