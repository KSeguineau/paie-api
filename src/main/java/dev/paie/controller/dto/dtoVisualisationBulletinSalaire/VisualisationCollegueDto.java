package dev.paie.controller.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisualisationCollegueDto {

    private String matricule;
    private String nom;
    private String prenom;
    private LocalDate ddn;

}
