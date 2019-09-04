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
public class BulletinSansSalaireDto {

    private ZonedDateTime dateCreation;
    private Periode periode;
    private String matricule;
    private String code;

    public BulletinSansSalaireDto(BulletinSalaire bulletinSalaire) {
        dateCreation = bulletinSalaire.getDateCreation();
        periode = bulletinSalaire.getPeriode();
        matricule = bulletinSalaire.getRemunerationEmploye().getMatricule();
        code = bulletinSalaire.getCode();
    }
}
