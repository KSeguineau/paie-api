package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisualisationLigneBulletinSalaireDto {

    private String rubriques;
    private BigDecimal base;
    private BigDecimal tauxSalarial;
    private BigDecimal montantSalarial;
    private BigDecimal tauxPatronal;
    private BigDecimal cotisationPatronale;
}
