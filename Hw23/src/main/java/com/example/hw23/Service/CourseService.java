package com.example.hw23.Service;

import com.example.hw23.ApiException.ApiException;
import com.example.hw23.Model.Course;
import com.example.hw23.Repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course,Integer id){
        Course oldCourse= courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("Course not found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
        Course course= courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }

    public  String getCourseTeacher(Integer id){
        Course course= courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("Course not found");
        }
        if(course.getTeacher()==null){
            throw new ApiException("Teacher for this class not found");
        }
        return course.getTeacher().getName();
    }

}
