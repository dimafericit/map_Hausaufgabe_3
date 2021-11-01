package com.company.Repository;

import com.company.Model.Course;

import java.util.Objects;

public class CourseRepository extends InMemoryRepository<Course> {

    public CourseRepository(){
        super();
    }

    @Override
    public Course update(Course obj) {
        Course CourseToUpdate = this.repoList.stream()
                .filter(course -> Objects.equals(course.getName(), obj.getName()))
                .findFirst()
                .orElseThrow();
        CourseToUpdate.setName(obj.getName());

        return CourseToUpdate;
    }

    public boolean exist(String name) {
        for (Course index : this.repoList)
            if (Objects.equals(index.getName(), name)){
                return true;
            }
        return false;
    }
}
