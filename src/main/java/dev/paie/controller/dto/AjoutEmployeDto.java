package dev.paie.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjoutEmployeDto {

    private String matricule;
    private String codeEntreprise;
    private String codeProfil;
    private String codeGrade;

}
