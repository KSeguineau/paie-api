package dev.paie.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.paie.entites.Periode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjoutBulletinSalaire {

    @NotNull
    private Periode periode;
    @NotNull
    private String matricule;
    @NotNull
    private BigDecimal primeExceptionnelle;

    /*public BigDecimal getPrimeExceptionnelleBigDecimal() {
        return new BigDecimal(primeExceptionnelle);
    }*/
}
