package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * la partie des cotisations non imposable du bulletin de salaire
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisualisationCotisationNonImposableDto {

    /**
     * liste des lignes de cotisations non imposables
     */
    private List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList;

    /**
     * le total des cotisations salariales
     */
    private BigDecimal totalRetenueSalarial;

    /**
     * le total des cotisations patronales
     */
    private BigDecimal totalRetenuePatronale;
    /**
     * le salaire net imposable
     */
    private BigDecimal salaireNetImposable;
}
