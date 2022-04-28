package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // ADD STUDENT DETAILS
    public Student addStudentPage(Student student) {
        return studentRepository.save(student);
    }

    //VIEW ALL DETAILS
    public List<Student> getALLStudents() {
        return studentRepository.findAll();
    }

    //VIEW STUDENT BY ID

    public Student getStudent(String id) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new Exception("Student Not Found!!!" + id)
        );

        return student;
    }

    //DELETE STUDENT DETAILS
    public String deleteStudent(String id) throws Exception {

        Student delStudent = studentRepository.findById(id).orElseThrow(
                () -> new Exception("Student Not Found!!! Unable To Perform Delete Operation" + id)
        );

        studentRepository.delete(delStudent);

        return "delete successfully";
    }

    //UPDATE STUDENT
    public Student updateStudent(String id, Student student) throws Exception {
        Student updtStudent = studentRepository.findById(id).orElseThrow(
                () -> new Exception("Student ID Not Found !! " + id)
        );
        updtStudent.setMarks(student.getMarks());

        updtStudent.setName(student.getName());

        return studentRepository.save(updtStudent);
    }

}
