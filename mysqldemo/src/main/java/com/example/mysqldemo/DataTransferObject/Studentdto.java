package com.example.mysqldemo.DataTransferObject;

import com.example.mysqldemo.entities.School;
import com.example.mysqldemo.entities.Student;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data

public class Studentdto {
    private Long studentId;
    private String studentName;
    private String gender;

    public static Studentdto convertTDTO(Student entity){
        Studentdto dto=Studentdto.builder()
                .studentId(entity.getId())
                .studentName(entity.getName())
                .gender(entity.getGender())
                .build();

                return dto;
    }

    public static List<Studentdto> convertToDTO(List<Student> entityList){
        List<Studentdto> dtos=new ArrayList<>();
        for (Student s: entityList){
            dtos.add(convertTDTO(s));
        }
        return dtos;
    }


}
