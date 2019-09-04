package dev.paie.controller.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.ws.soap.Addressing;
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
