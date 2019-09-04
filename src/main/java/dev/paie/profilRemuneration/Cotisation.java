package dev.paie.profilRemuneration;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The type Cotisation.
 */
@Entity
public class Cotisation {

    /**
     * id de la cotisation
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * code de la cotisation
     */

    private String code;

    /**
     * libelle de la cotisation
     */
    private String libelle;

    /**
     * represente le taux salarial
     */
    @Column(precision = 25, scale = 6)
    private BigDecimal tauxSalarial;

    /**
     * represente le taux patronal
     */
    @Column(precision = 25, scale = 6)
    private BigDecimal tauxPatronal;

    /**
     * indique si la cotisation est imposable
     */
    private Boolean imposable = false;

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
     * Gets libelle.
     *
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets libelle.
     *
     * @param libelle the libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Gets taux salarial.
     *
     * @return the taux salarial
     */
    public BigDecimal getTauxSalarial() {
        return tauxSalarial;
    }

    /**
     * Sets taux salarial.
     *
     * @param tauxSalarial the taux salarial
     */
    public void setTauxSalarial(BigDecimal tauxSalarial) {
        this.tauxSalarial = tauxSalarial;
    }

    /**
     * Gets taux patronal.
     *
     * @return the taux patronal
     */
    public BigDecimal getTauxPatronal() {
        return tauxPatronal;
    }

    /**
     * Sets taux patronal.
     *
     * @param tauxPatronal the taux patronal
     */
    public void setTauxPatronal(BigDecimal tauxPatronal) {
        this.tauxPatronal = tauxPatronal;
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

    /**
     * Gets imposable.
     *
     * @return the imposable
     */
    public Boolean getImposable() {
        return imposable;
    }

    /**
     * Sets imposable.
     *
     * @param imposable the imposable
     */
    public void setImposable(Boolean imposable) {
        this.imposable = imposable;
    }
}
