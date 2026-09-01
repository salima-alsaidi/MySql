package com.example.mysqldemo.entities;

import com.example.mysqldemo.entities.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
