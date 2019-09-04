package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * information sur la période du bulletin de salaire
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisualisationPeriodeDto {

    /**
     * date de début
     */
    private LocalDate dateDebut;
    /**
     * date de fin
     */
    private LocalDate dateFin;
}
