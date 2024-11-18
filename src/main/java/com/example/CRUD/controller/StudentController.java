package com.example.CRUD.controller;

import com.example.CRUD.dao.StudentDao;
import com.example.CRUD.dao.request.StudentRequestDao;
import com.example.CRUD.entity.Student;
import com.example.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/allstudents")
    public List<StudentDao> getAll(){
        return studentService.getStudents();
    }

    @GetMapping("/{Id}")
    public Optional<Student> getBId(@PathVariable("Id") Long Id){
        return studentService.getStudent(Id);
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentRequestDao student){
        studentService.save(student);
    }

    @DeleteMapping("/{Id}")
    public void saveUpdate(@PathVariable("Id") Long Id){
        studentService.delete(Id);
    }

}
