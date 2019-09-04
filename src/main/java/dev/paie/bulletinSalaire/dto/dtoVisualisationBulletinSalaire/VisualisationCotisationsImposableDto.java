package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisualisationCotisationsImposableDto {

    private List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList;
    private BigDecimal salaireNetAPayer;
}
