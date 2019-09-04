package dev.paie.bulletinSalaire.dto;

import dev.paie.bulletinSalaire.dto.dtoVisualisationBulletinSalaire.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisualisationBulletinSalaireDto {

    private VisualisationEntreprisDto Entreprise;
    private VisualisationPeriodeDto Periode;
    private VisualisationCollegueDto Collegue;
    private VisualisationSalaireDto Salaire;
    private VisualisationCotisationNonImposableDto CotisationNonImposable;
    private VisualisationCotisationsImposableDto CotisationsImposable;


}
