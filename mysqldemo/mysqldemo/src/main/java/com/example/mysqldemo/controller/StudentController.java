package com.cl.mysqldemo.controllers;

import com.cl.mysqldemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("add")
    public Long addStudent(
            @RequestParam String name,
            @RequestParam String major,
            @RequestParam String gender,
            @RequestParam String phoneNumber,
            @RequestParam String parentName,
            @RequestParam Long schoolId
    ){
        return studentService.addStudent(name, major, gender, phoneNumber, parentName, schoolId);
    }
}
