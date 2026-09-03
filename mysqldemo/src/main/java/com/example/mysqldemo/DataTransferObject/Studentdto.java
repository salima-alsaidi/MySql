package com.example.mysqldemo.DataTransferObject;

import com.example.mysqldemo.entities.School;
import com.example.mysqldemo.entities.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Studentdto {
    @Positive
    private Long studentId;
    @NotBlank(message = "Student id must not be blank")
    @Size(min=2, max =10, message = "student name must be between 2 and 10")
    private String studentName;
    @NotBlank(message = "gender must not be blank")
    @Size(min=4, max=6, message="gender must be between 4 and 6")
    private String gender;
    @NotBlank(message = "A primary contact number must be supplied")
    @Size(min = 7, max = 15, message = "Please enter a valid telephone number between 7 and 15 digits")
    private String phoneNumber;
    @NotBlank(message = "Guardian or parental contact name missing")
    @Size(min = 7, max = 15, message = "Parent or guardian name must be within 7 to 15 characters")
    private String parentName;
    @NotBlank(message = "You must specify the student's academic major")
    @Size(min = 2, max = 15, message = "The designated major must contain between 2 and 15 characters")
    private String major;
    @Positive
    private Long schoolId;

    public static Studentdto convertTDTO(Student entity){
        Studentdto dto=Studentdto.builder()
                .studentId(entity.getId())
                .studentName(entity.getName())
                .gender(entity.getGender()).major(entity.getMajor())
                .phoneNumber((entity.getPhoneNumber()))
                .parentName(entity.getParentName())
                .schoolId(entity.getId())
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
