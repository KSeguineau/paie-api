package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * la partie cotisation imposable du bulletin de salaire
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisualisationCotisationsImposableDto {

    /**
     * liste des lignes de cotisation imposable du bulletin de salaire
     */
    private List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList;
    /**
     * salaire net a payer
     */
    private BigDecimal salaireNetAPayer;
}
