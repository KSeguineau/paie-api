package dev.paie.controller.dto;

import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Periode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BulletinSalaireDto {

    private ZonedDateTime dateCreation;
    private Periode periode;
    private String matricule;
    private SalaireDto salaireDto;


    public BulletinSalaireDto(BulletinSalaire bulletinSalaire,SalaireDto salaireDto) {
        dateCreation=bulletinSalaire.getDateCreation();
        periode= bulletinSalaire.getPeriode();
        matricule = bulletinSalaire.getRemunerationEmploye().getMatricule();
        this.salaireDto = salaireDto;

    }
}
