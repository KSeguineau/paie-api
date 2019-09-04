package dev.paie.bulletinSalaire.dto;

import dev.paie.periode.Periode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjoutBulletinSalaireDto {

    @NotBlank
    private Periode periode;
    @NotBlank
    private String matricule;
    @NotBlank
    private BigDecimal primeExceptionnelle;


}
