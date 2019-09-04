package dev.paie.grade;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The type Grade.
 */
@Entity
public class Grade {

	/**
	 * id du grade
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	/**
	 * code du grade
	 */
	private String code;
	/**
	 * nombre d’heure de travail durant la période
	 */
    @Column(precision = 25, scale = 6)
    private BigDecimal nbHeuresBase;
	/**
	 * taux horaire
	 */
	@Column(precision = 25, scale = 6)
    private BigDecimal tauxBase;

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
	 * Gets nb heures base.
	 *
	 * @return the nb heures base
	 */
	public BigDecimal getNbHeuresBase() {
        return nbHeuresBase;
    }

	/**
	 * Sets nb heures base.
	 *
	 * @param nbHeuresBase the nb heures base
	 */
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
        this.nbHeuresBase = nbHeuresBase;
    }

	/**
	 * Gets taux base.
	 *
	 * @return the taux base
	 */
	public BigDecimal getTauxBase() {
        return tauxBase;
    }

	/**
	 * Sets taux base.
	 *
	 * @param tauxBase the taux base
	 */
	public void setTauxBase(BigDecimal tauxBase) {
        this.tauxBase = tauxBase;
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
