package dev.paie.bulletinSalaire.dto;

import dev.paie.periode.Periode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * objet que nous envoi la requete pour ajouter un bulletin de salaire
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjoutBulletinSalaireDto {

    /**
     * periode du bulletin de salaire
     */
    @NotBlank
    private Periode periode;
    /**
     * matricule du collegue
     */
    @NotBlank
    private String matricule;
    /**
     * prime exceptionnelle du collegue
     */
    @NotBlank
    private BigDecimal primeExceptionnelle;


}
