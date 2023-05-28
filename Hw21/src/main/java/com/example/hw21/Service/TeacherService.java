package com.example.hw21.Service;

import com.example.hw21.ApiException.ApiException;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
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
            throw new ApiException("teacher not found");
        }

        teacherRepository.delete(teacher);
    }

}
