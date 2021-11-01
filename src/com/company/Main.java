package com.company;

import com.company.Model.Course;
import com.company.Model.Person;
import com.company.Model.Student;

public class Main {

    public static void main(String[] args) {
        //studentii
	    Student obj1 = new Student("Dima", "Burlac");
        Student obj2 = new Student("Dimitri", "Burlac");
        Student obj3 = new Student("Domi", "Burlac");

        //cursurile
        Person pers1 = new Person("Benta", "Iulian");
        Course obja = new Course("fp", pers1, 2, 6);
        Course objb = new Course("map", pers1, 8, 6);

        RegistrationSystem registru = new RegistrationSystem();
        registru.addStudent(obj1);
        registru.addStudent(obj2);
        registru.addCourse(obja);
        registru.addCourse(objb);

        registru.register(obja, obj1);
        registru.register(obja, obj2);
        registru.register(objb, obj1);

        System.out.println(registru.retrieveStudentsEnrolledForACourse(obja));
        System.out.println(registru.retrieveCoursesWithFreePlaces());
        System.out.println(obj1.getCredits());
    }
}
