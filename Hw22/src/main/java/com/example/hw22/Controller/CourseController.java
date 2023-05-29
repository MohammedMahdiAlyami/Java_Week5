package com.example.hw22.Controller;

import com.example.hw22.ApiResponse.ApiResponse;
import com.example.hw22.Model.Course;
import com.example.hw22.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/course")
@RestController
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourse() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course, @Valid @PathVariable Integer id) {
        courseService.updateCourse(course, id);
        return ResponseEntity.status(200).body("Course Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted");
    }

    @GetMapping("/get-teacher/{id}")
    private ResponseEntity getCourseTeacher(@PathVariable @Valid Integer id) {
        String teacherName = courseService.getCourseTeacher(id);
        return ResponseEntity.status(200).body(teacherName);
    }

}
