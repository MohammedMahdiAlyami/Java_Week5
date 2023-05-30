package com.example.hw23.Controller;

import com.example.hw23.ApiResponse.ApiResponse;
import com.example.hw23.Model.Teacher;
import com.example.hw23.Service.TeacherService;
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
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @Valid @PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("Teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getTeacherById(@Valid @PathVariable Integer id){
        Teacher teacher =teacherService.getTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }

    @GetMapping("/assign/{teacher_id}/{course_id}")
    private ResponseEntity assignTeacherToCourse(@Valid@PathVariable Integer teacher_id,@Valid@PathVariable Integer course_id){
        teacherService.assignTeacherToCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body("Teacher assigned");
    }
}
