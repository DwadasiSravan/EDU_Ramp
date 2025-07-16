package com.example.Student.service;

import com.example.Student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudService {

    Student createStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    void updateStudentById(Long id, Student updatedStudent);

    void deleteByID(Long id);
}
