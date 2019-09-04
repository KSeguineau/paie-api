package dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisualisationCotisationNonImposableDto {

    private List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList;
    private BigDecimal totalRetenueSalarial;
    private BigDecimal totalRetenuePatronale;
    private BigDecimal salaireNetImposable;
}
