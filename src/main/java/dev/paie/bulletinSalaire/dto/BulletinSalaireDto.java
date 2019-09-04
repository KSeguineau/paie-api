package dev.paie.bulletinSalaire.dto;

import dev.paie.bulletinSalaire.BulletinSalaire;
import dev.paie.periode.Periode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BulletinSalaireDto {

    private ZonedDateTime dateCreation;
    private Periode periode;
    private String matricule;
    private String code;
    private SalaireDto salaireDto;


    public BulletinSalaireDto(BulletinSalaire bulletinSalaire, SalaireDto salaireDto) {
        dateCreation=bulletinSalaire.getDateCreation();
        periode= bulletinSalaire.getPeriode();
        matricule = bulletinSalaire.getRemunerationEmploye().getMatricule();
        code = bulletinSalaire.getCode();
        this.salaireDto = salaireDto;
    }


}
