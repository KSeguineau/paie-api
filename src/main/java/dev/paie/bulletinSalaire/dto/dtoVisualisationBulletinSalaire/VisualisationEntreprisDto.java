package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * information de l’entreprise
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisualisationEntreprisDto {

    /**
     * denomination de l’entreprise
     */
    private String denomination;
    /**
     * siret de l’entreprise
     */
    private String siret;
}
