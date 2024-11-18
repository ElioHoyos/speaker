package com.example.CRUD.service;

import com.example.CRUD.dao.StudentDao;
import com.example.CRUD.dao.request.StudentRequestDao;
import com.example.CRUD.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDao> getStudents();
    Optional<Student> getStudent(Long Id);
    void save(StudentRequestDao student);
    void delete(Long id);

}
