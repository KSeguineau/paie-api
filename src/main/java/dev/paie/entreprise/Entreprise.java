package dev.paie.entreprise;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Entreprise.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise {
    /**
     * id de l’entreprise
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * code de l’entreprise
     */
    private String code;
    /**
     * siret de l’entreprise
     */
    private String siret;
    /**
     * denomination de l’entreprise
     */
    private String denomination;
    /**
     * adresse de l’entreprise
     */
    private String adresse;
    /**
     * urssaf de l’entreprise
     */
    private String urssaf;
    /**
     * codeNaf de l’entreprise
     */
    private String codeNaf;


    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets denomination.
     *
     * @return the denomination
     */
    public String getDenomination() {
        return denomination;
    }

    /**
     * Sets denomination.
     *
     * @param denomination the denomination
     */
    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    /**
     * Gets adresse.
     *
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse the adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Gets siret.
     *
     * @return the siret
     */
    public String getSiret() {
        return siret;
    }

    /**
     * Sets siret.
     *
     * @param siret the siret
     */
    public void setSiret(String siret) {
        this.siret = siret;
    }

    /**
     * Gets urssaf.
     *
     * @return the urssaf
     */
    public String getUrssaf() {
        return urssaf;
    }

    /**
     * Sets urssaf.
     *
     * @param urssaf the urssaf
     */
    public void setUrssaf(String urssaf) {
        this.urssaf = urssaf;
    }

    /**
     * Gets code naf.
     *
     * @return the code naf
     */
    public String getCodeNaf() {
        return codeNaf;
    }

    /**
     * Sets code naf.
     *
     * @param codeNaf the code naf
     */
    public void setCodeNaf(String codeNaf) {
        this.codeNaf = codeNaf;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }


}
