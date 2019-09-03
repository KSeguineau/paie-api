package dev.paie.controller.dto;

import dev.paie.entites.RemunerationEmploye;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemunerationEmployeDto {

    private String matricule;
    private ZonedDateTime dateCreation;
    private String gradeCode;

    public RemunerationEmployeDto(RemunerationEmploye remunerationEmploye) {
        this.matricule = remunerationEmploye.getMatricule();
        this.dateCreation = remunerationEmploye.getDateCreation();
        this.gradeCode = remunerationEmploye.getGrade().getCode();
    }
}
