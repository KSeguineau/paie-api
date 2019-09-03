package dev.paie.entites.api_collegue_entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Clase représentant un collegue
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collegue {

    /**
     * matricule du collegue
     */
    @Id
    private String matricule;
    /**
     * nom du collegue
     */
    private String nom;
    /**
     * prenom du collegue
     */
    private String prenom;
    /**
     * email du collegue
     */
    private String email;
    /**
     * date de naissance du collegue
     */
    private LocalDate ddn;
    /**
     * url de la photo du collegue
     */
    private String photoUrl;

}