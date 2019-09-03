package dev.paie.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjoutEmployeDto {

    @NotNull
    private String matricule;
    @NotNull
    private String codeEntreprise;
    @NotNull
    private String codeProfil;
    @NotNull
    private String codeGrade;

}
