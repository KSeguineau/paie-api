package dev.paie.bulletinSalaire.dto;

import dev.paie.bulletinSalaire.BulletinSalaire;
import dev.paie.periode.Periode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * informations que l’on renvoi apres la creation d’un bulletin de salaire
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BulletinSalaireDto {

    /**
     * date de creation du bulletin de salaire
     */
    private ZonedDateTime dateCreation;
    /**
     * periode du bulletin de salaire
     */
    private Periode periode;
    /**
     * matricule du collegue
     */
    private String matricule;
    /**
     * code du bulletin de salaire
     */
    private String code;
    /**
     * objet contenant les montants du salaire
     */
    private SalaireDto salaireDto;


    /**
     * Instantiates a new Bulletin salaire dto.
     *
     * @param bulletinSalaire le bulletin de salaire
     * @param salaireDto      le SalaireDto
     */
    public BulletinSalaireDto(BulletinSalaire bulletinSalaire, SalaireDto salaireDto) {
        dateCreation=bulletinSalaire.getDateCreation();
        periode= bulletinSalaire.getPeriode();
        matricule = bulletinSalaire.getRemunerationEmploye().getMatricule();
        code = bulletinSalaire.getCode();
        this.salaireDto = salaireDto;
    }


}
