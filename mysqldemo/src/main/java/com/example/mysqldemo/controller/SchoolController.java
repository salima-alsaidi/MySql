package com.example.mysqldemo.controller;

import com.example.mysqldemo.DataTransferObject.Schooldto;
import com.example.mysqldemo.Services.SchoolService;
import com.example.mysqldemo.entities.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolController {
    SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;

    }

    @PostMapping("add")
    public Long addSchool(@RequestParam String schoolName, @RequestParam String location) {
        return schoolService.createSchool(schoolName, location);

    }

    @GetMapping("getAll")

    public List<Schooldto> getAllSchools() {
        List<Schooldto> schools=Schooldto.convertToDTO(schoolService.getAllSchools());
        return schools;

    }

    @GetMapping("getById")
    public Schooldto getById(@RequestParam Long id) {
        return Schooldto.convrToDTO(schoolService.getById(id));
    }


    @PutMapping("update")
    public Schooldto updateSchool(@RequestParam Long id, @RequestParam String name, @RequestParam String location) {
        return Schooldto.convrToDTO(schoolService.updateSchool(id, name, location));
    }
    @DeleteMapping("deleteById")
    public Boolean deleteSchool(@RequestParam Long id){
        return schoolService.deleteById(id);
    }




}
