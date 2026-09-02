package com.example.mysqldemo.DataTransferObject;

import com.example.mysqldemo.entities.School;
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

public class Schooldto {
    private Long schoolId;
    private String schoolName;
    private String schoolLocation;

   public static Schooldto convrToDTO(School entity){
        Schooldto dto=Schooldto.builder()
                .schoolId(entity.getId())
                .schoolName(entity.getName())
                .schoolLocation(entity.getLocation())
                .build();

        return dto;
    }
    public static List<Schooldto> convertToDTO(List<School> entityList){
       List<Schooldto> dtos=new ArrayList<>();
       for(School s: entityList){
           dtos.add(convrToDTO(s));
       }
       return dtos;
    }

}
