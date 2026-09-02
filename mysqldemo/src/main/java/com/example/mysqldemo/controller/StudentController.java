package com.example.mysqldemo.controller;

import com.example.mysqldemo.DataTransferObject.Schooldto;
import com.example.mysqldemo.DataTransferObject.Studentdto;
import com.example.mysqldemo.Repositories.StudentRepository;
import com.example.mysqldemo.Services.StudentService;
import com.example.mysqldemo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getAll")

    public List<Studentdto> getAllStudents(){
        List<Studentdto> students=Studentdto.convertToDTO(studentService.getAllStudents());
        return students;
    }


    @GetMapping("getByID")
    public Studentdto getById(@RequestParam Long id){
        return Studentdto.convertTDTO(studentService.getById(id));
    }

}
