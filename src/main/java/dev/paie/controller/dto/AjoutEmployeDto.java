package dev.paie.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjoutEmployeDto {

    @NotBlank
    private String matricule;
    @NotBlank
    private String codeEntreprise;
    @NotBlank
    private String codeProfil;
    @NotBlank
    private String codeGrade;

}
