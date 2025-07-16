package com.example.Student.service;

import com.example.Student.entity.Student;
import com.example.Student.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudService{

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findAllById(id);
    }

    @Override
    public void updateStudentById(Long id, Student updatedStudent) {
        studentRepo.findAllById(id).ifPresent(curStudent -> {
        if(updatedStudent.getFirstName() != null && !updatedStudent.getFirstName().isBlank()) curStudent.setFirstName(updatedStudent.getFirstName());
        if(updatedStudent.getLastName() != null && !updatedStudent.getLastName().isBlank()) curStudent.setLastName(updatedStudent.getLastName());
        if(updatedStudent.getEmail() != null && !updatedStudent.getEmail().isBlank()) curStudent.setEmail(updatedStudent.getEmail());
        if(updatedStudent.getMobileNumber() != null && !updatedStudent.getMobileNumber().isBlank()) curStudent.setMobileNumber(updatedStudent.getMobileNumber());
        studentRepo.save(curStudent);
        });

    }

    @Override
    public void deleteByID(Long id) {
        studentRepo.deleteById(id);
    }
}
