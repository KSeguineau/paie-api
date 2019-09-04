package dev.paie.controller.dto;

import dev.paie.entites.RemunerationEmploye;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class RemunerationEmployeDto {

    private String matricule;
    private ZonedDateTime dateCreation;
    private String gradeCode;

    public RemunerationEmployeDto(RemunerationEmploye remunerationEmploye) {
        this.matricule = remunerationEmploye.getMatricule();
        this.dateCreation = remunerationEmploye.getDateCreation();
        this.gradeCode = remunerationEmploye.getGrade().getCode();
    }

    public RemunerationEmployeDto(String matricule, ZonedDateTime dateCreation, String gradeCode) {
        this.matricule = matricule;
        this.dateCreation = dateCreation;
        this.gradeCode = gradeCode;
    }
}
