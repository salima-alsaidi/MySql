package com.example.mysqldemo.controller;

import com.example.mysqldemo.DataTransferObject.Schooldto;
import com.example.mysqldemo.DataTransferObject.Studentdto;
import com.example.mysqldemo.Repositories.StudentRepository;
import com.example.mysqldemo.Services.StudentService;
import com.example.mysqldemo.entities.Student;
import jakarta.validation.Valid;
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
    public Long addStudent(@Valid @RequestBody Studentdto dto)
    {
        return studentService.addStudent( dto.getStudentName(), dto.getMajor(),dto.getGender(), dto.getPhoneNumber(),dto.getParentName(), dto.getSchoolId());
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

    @PutMapping("update")
    public Studentdto updateStudent(@Valid @RequestBody Studentdto dto){
        return Studentdto.convertTDTO(studentService.updateStudent(dto.getStudentId(),
                dto.getStudentName(),
                dto.getGender(),
                dto.getPhoneNumber(),
                dto.getParentName(),
                dto.getMajor()));
    }

    @PutMapping("deletById")

    public Boolean deletById(@RequestParam Long id){
        return studentService.deletById(id);
    }

}
