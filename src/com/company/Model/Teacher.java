package com.company.Model;

import com.company.Model.Course;
import com.company.Model.Person;

import java.util.List;

public class Teacher extends Person {
    private List<Course> course;

    Teacher(String name, String vorname, List<Course> lista){
        super(name, vorname);
        this.course = lista;
    }
}
