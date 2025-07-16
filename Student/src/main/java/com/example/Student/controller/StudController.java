package com.example.Student.controller;

import com.example.Student.StudentApplication;
import com.example.Student.entity.Student;
import com.example.Student.service.StudService;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stud")
public class StudController {

    private final StudService studService;

    public StudController(StudService studService) {
        this.studService = studService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studService.createStudent(student);

    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public void updateStudentById(@PathVariable Long id,@RequestBody Student student){
        studService.updateStudentById(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable Long id){
        studService.deleteByID(id);
    }



}
