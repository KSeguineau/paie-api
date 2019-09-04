package dev.paie.profilRemuneration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


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
