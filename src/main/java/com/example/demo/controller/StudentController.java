package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")

    public Student addStudentPage(@RequestBody Student student) throws Exception {
        return studentService.addStudentPage(student);
    }


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getALLStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) throws Exception {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) throws Exception {
        return studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) throws Exception {
        return studentService.updateStudent(id, student);
    }


}
