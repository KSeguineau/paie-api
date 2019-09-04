package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

/**
 * information d’une du salaire ou des cotisations
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisualisationLigneBulletinSalaireDto {

    /**
     * nom
     */
    private String rubriques;
    /**
     * montant de base
     */
    private BigDecimal base;
    /**
     * le taux tauxSalarial
     */
    private BigDecimal tauxSalarial;
    /**
     * le montantSalarial
     */
    private BigDecimal montantSalarial;
    /**
     * le tauxPatronal
     */
    private BigDecimal tauxPatronal;
    /**
     * la cotisationPatronale
     */
    private BigDecimal cotisationPatronale;
}
