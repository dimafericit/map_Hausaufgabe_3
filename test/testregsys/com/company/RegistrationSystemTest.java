package com.company;

import com.company.Model.Course;
import com.company.Model.Student;
import com.company.Model.Teacher;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationSystemTest {
    private RegistrationSystem reg;

    @Test
    void addStudent() {
        //studenti
        Student student1 = new Student("Ion", "Ioan");
        Student student2 = new Student("Mircea", "Maier");
        reg = new RegistrationSystem();

        reg.addStudent(student1);
        reg.addStudent(student2);
        assertEquals(reg.getAllStudents().getAll(), Arrays.asList(student1, student2));
    }

    @Test
    void addCourse() {
        Teacher teacher1 = new Teacher("Claudiu", "Pop");
        Teacher teacher2 = new Teacher("Radu", "Dragan");

        Course course1 = new Course("Fundamentele programarii", teacher1, 100, 6);
        Course course2 = new Course("Geometrie", teacher2, 200, 6);
        reg = new RegistrationSystem();

        reg.addCourse(course1);
        reg.addCourse(course2);
        assertEquals(reg.getAllCourse().getAll(), Arrays.asList(course1, course2));
    }

    @Test
    void register() {
        Teacher teacher1 = new Teacher("Claudiu", "Pop");
        Teacher teacher2 = new Teacher("Radu", "Dragan");
        Teacher teacher3 = new Teacher("Ana", "Maria");

        Course course1 = new Course("Fundamentele programarii", teacher1, 2, 6);
        Course course2 = new Course("Geometrie", teacher2, 200, 6);
        Course course3 = new Course("Fundamentele algebrice ale programarii",teacher2, 180, 6);
        Course course4 = new Course("Programare logica", teacher3, 90, 6);
        Course course5 = new Course("Baze de date", teacher3, 70, 7);


        Student student1 = new Student("Ion", "Ioan");
        Student student2 = new Student("Mircea", "Maier");
        Student student3 = new Student("Mircea", "Maier");
        reg = new RegistrationSystem();

        reg.register(course1,student1);
        reg.register(course2,student1);
        assertEquals(student1.getCredits(), course1.getCredits() + course2.getCredits());

        reg.register(course1,student2);
        assertEquals(student2.getCredits(), course1.getCredits());

        //cazul in care studentul nu are destule credite pentru a aduaga un acurs nou
        reg.register(course3,student1);
        reg.register(course4,student1);
        assertFalse(reg.register(course5, student1));

        //cazul in care cursul nu mai are locuri disponibile
        assertFalse(reg.register(course1, student3));

    }

    @Test
    void retrieveCoursesWithFreePlaces() {
        Teacher teacher1 = new Teacher("Claudiu", "Pop");
        Teacher teacher2 = new Teacher("Radu", "Dragan");

        Course course1 = new Course("Fundamentele programarii", teacher1, 2, 6);
        Course course2 = new Course("Geometrie", teacher2, 200, 6);
        Course course3 = new Course("Fundamentele algebrice ale programarii",teacher2, 180, 6);

        Student student1 = new Student("Ion", "Ioan");
        Student student2 = new Student("Mircea", "Maier");
        Student student3 = new Student("Mircea", "Maier");
        reg = new RegistrationSystem();

        reg.register(course1,student1);
        reg.register(course1,student2);
        reg.register(course1,student3);

        reg.addCourse(course1);
        reg.addCourse(course2);
        reg.addCourse(course3);

        assertEquals(reg.retrieveCoursesWithFreePlaces(), Arrays.asList(course2, course3));
    }
}