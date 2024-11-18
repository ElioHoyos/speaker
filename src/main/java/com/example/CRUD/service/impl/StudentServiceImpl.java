package com.example.CRUD.service.impl;

import com.example.CRUD.dao.StudentDao;
import com.example.CRUD.dao.request.StudentRequestDao;
import com.example.CRUD.entity.Student;
import com.example.CRUD.repository.StudentRepository;
import com.example.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDao> getStudents() {
        return studentRepository.findAll().stream().map(
                student -> StudentDao.builder()
                        .status(student.getStatus())
                        .name(student.getName())
                        .dni(student.getDni())
                        .cellphone(student.getCellphone())
                        .email(student.getEmail())
                        .age(student.getAge())
                        .id(student.getId()).build()
        ).toList();
    }

    @Override
    public Optional<Student> getStudent(Long Id) {
        return Optional.empty();
    }

    @Override
    public void save(StudentRequestDao student) {
        studentRepository.save(Student.builder()
                        .name(student.getName())
                        .dni(student.getDni())
                        .cellphone(student.getCellphone())
                        .email(student.getEmail())
                        .age(student.getAge())
                        .status(student.getStatus())
                        .build());
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
