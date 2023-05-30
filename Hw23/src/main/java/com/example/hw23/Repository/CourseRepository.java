package com.example.hw23.Repository;

import com.example.hw23.Model.Course;
import com.example.hw23.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);
    List<Course> findCourseByStudent(Student student);

}