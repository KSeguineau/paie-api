package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * les informations sur le collegue dans le bulletin de salaire
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisualisationCollegueDto {

    /**
     * matricule d’un collegue
     */
    private String matricule;
    /**
     * nom d’un collegue
     */
    private String nom;
    /**
     * prenom d’un collegue
     */
    private String prenom;
    /**
     * date de naissance d’un collegue
     */
    private LocalDate ddn;

}
