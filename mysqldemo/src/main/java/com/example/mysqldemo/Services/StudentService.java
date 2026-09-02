package com.example.mysqldemo.Services;

import com.example.mysqldemo.DataTransferObject.Studentdto;
import com.example.mysqldemo.Repositories.SchoolRepository;
import com.example.mysqldemo.Repositories.StudentRepository;
import com.example.mysqldemo.Services.SchoolService;
import com.example.mysqldemo.entities.School;
import com.example.mysqldemo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    SchoolService schoolService;

    StudentRepository studentRepository;

    SchoolRepository schoolRepository;

    @Autowired
    public StudentService(SchoolService schoolService, StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.schoolService = schoolService;
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }



    public Long addStudent(String name, String major, String gender,
                           String phoneNumber, String parentName, Long schoolId) {
        School school = schoolService.getById(schoolId);
        if(school == null || school.getIsActive() == false){
            return -1l;
        }
        Student student = new Student();
        student.setName(name);
        student.setMajor(major);
        student.setGender(gender);
        student.setPhoneNumber(phoneNumber);
        student.setPhoneNumber(parentName);

        student.setIsActive(true);
        student.setCreatedDate(new Date());
        Student savedStudent = studentRepository.save(student);

        List<Student> studentList = school.getStudents();
        studentList.add(savedStudent);
        school.setStudents(studentList);
        schoolRepository.save(school);

        return savedStudent.getId();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent() && student.get().getIsActive()) {
            return student.get();
        }
        return new Student();
    }

    public Student updateStudent(Long id, String name, String major){
        Student studentToUpdate=studentRepository.getById(id);
        if(studentToUpdate==null){
            return new Student();
        }
        studentToUpdate.setId(id);
        studentToUpdate.setName(name);
        studentToUpdate.setMajor(major);
        studentToUpdate=studentRepository.save(studentToUpdate);
        return studentToUpdate;
    }

    public Boolean deletById(Long id) {
        Student studentToUpdate = studentRepository.getById(id);
        if (studentToUpdate == null) {
            return false;
        }

        studentToUpdate.setIsActive(false);
        studentToUpdate.setUpdatedDate(new Date());
        studentRepository.save(studentToUpdate);
        return true;
    }
}
