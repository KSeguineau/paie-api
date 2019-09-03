package dev.paie.controller.dto;

import dev.paie.entites.Entreprise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrepriseDto {

    private String code;
    private String denomination;

    public EntrepriseDto(Entreprise entreprise) {
        this.code = entreprise.getCode();
        this.denomination=entreprise.getDenomination();
    }
}
