package dev.paie.controller.dto.dtoVisualisationBulletinSalaire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisualisationPeriodeDto {

    private LocalDate dateDebut;
    private LocalDate dateFin;
}
