package dev.paie.grade;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDto {

    private String code;
    private BigDecimal tauxHoraire;
    private BigDecimal nbHeure;

    public GradeDto(Grade grade) {
        this.code = grade.getCode();
        this.tauxHoraire = grade.getTauxBase();
        this.nbHeure = grade.getNbHeuresBase();
    }
}
