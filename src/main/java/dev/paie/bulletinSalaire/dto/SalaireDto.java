package dev.paie.bulletinSalaire.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class SalaireDto {

    private BigDecimal salaireBrut;
    private BigDecimal salaireNetImposable;
    private BigDecimal salaireNetAPayer;


    public SalaireDto(BigDecimal salaireBrut, BigDecimal salaireNetImposable, BigDecimal salaireNetAPayer) {
        this.salaireBrut = salaireBrut;
        this.salaireNetImposable = salaireNetImposable;
        this.salaireNetAPayer = salaireNetAPayer;
    }
}
