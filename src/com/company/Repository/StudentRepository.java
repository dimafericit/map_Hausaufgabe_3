package com.company.Repository;

import com.company.Model.Course;
import com.company.Model.Student;

public class StudentRepository extends InMemoryRepository<Student> {

    public StudentRepository(){
        super();
    }

    @Override
    public Student update(Student obj) {
        Student studentToUpdate = this.repoList.stream()
                .filter(student -> student.getStudentid() == obj.getStudentid())
                .findFirst()
                .orElseThrow();

        studentToUpdate.setName(obj.getName());

        return studentToUpdate;
    }

    public boolean exist(Student stud) {
        for (Student index : this.repoList)
            if (index == stud){
                return true;
            }
        return false;
    }

}

