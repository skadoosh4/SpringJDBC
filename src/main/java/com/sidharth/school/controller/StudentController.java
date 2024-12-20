package com.sidharth.school.controller;

import com.sidharth.school.model.Student;
import com.sidharth.school.model.Teacher;
import com.sidharth.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Student>> getAllStudents(@RequestParam(required = false) Integer age){
        return ResponseEntity.ok(studentService.getAllStudents(age));
    }

    @GetMapping("/{id}/teachers")
    public ResponseEntity<Iterable<Teacher>> getTeachersByStudentId(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getTeachersByStudentId(id));
    }

    @PostMapping
    public void createStudent(@RequestBody Student student , @RequestParam Long teacherId){
        studentService.createStudentAndAssignTeacher(student , teacherId);
    }
}
