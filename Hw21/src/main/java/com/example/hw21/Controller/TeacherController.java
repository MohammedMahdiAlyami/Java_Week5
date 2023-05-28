package com.example.hw21.Controller;

import com.example.hw21.Model.Teacher;
import com.example.hw21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeaches(){
        List<Teacher> teachers=teacherService.getAllTeacher();
        return ResponseEntity.status(200).body(teachers);
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @Valid @PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("teacher Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");
    }

}