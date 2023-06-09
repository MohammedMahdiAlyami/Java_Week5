package com.example.hw23.Service;


import com.example.hw23.ApiException.ApiException;
import com.example.hw23.Model.Course;
import com.example.hw23.Model.Teacher;
import com.example.hw23.Repository.CourseRepository;
import com.example.hw23.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher,Integer id){
        Teacher oldTeacher= teacherRepository.findTeacherById(id);
        if(oldTeacher==null){
            throw new ApiException("Teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setEmail(teacher.getEmail());

        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher= teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher not found");
        }

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id){
        Teacher teacher= teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher not found");
        }
        return teacher;
    }

    public  void assignTeacherToCourse(Integer teacher_id,Integer course_id){

        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);

        if(teacher==null||course==null){
            throw  new ApiException("It is wrong");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

}
