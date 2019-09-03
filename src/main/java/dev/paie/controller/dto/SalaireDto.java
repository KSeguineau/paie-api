package dev.paie.controller.dto;

import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.service.BulletinSalaireService;
import dev.paie.service.RemunerationEmployeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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
