package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * la partie salaire du bulletin de salaire
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisualisationSalaireDto {

    /**
     * liste des ligne du salaire
     */
    private List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList;
    /**
     * salaire brut
     */
    private BigDecimal salaireBrut;
}
