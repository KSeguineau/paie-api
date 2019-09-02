package dev.paie.entites;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * Represente le bulletin de salaire.
 */
@Entity
public class BulletinSalaire {

    /**
     * id du bulletin
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    /**
     * Represente la remuneration de l’employe
     */
	@OneToOne
	private RemunerationEmploye remunerationEmploye;

    /**
     * represente la période de travail correspondant au salaire
     */
	@ManyToOne
	@JoinColumn(name="periode_id")
	private Periode periode;

    /**
     * represente le montant de la prime exceptionnelle
     */
	@Column(precision = 25,scale = 6)
	private BigDecimal primeExceptionnelle;

    /**
     * Gets remuneration employe.
     *
     * @return the remuneration employe
     */
    public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

    /**
     * Sets remuneration employe.
     *
     * @param remunerationEmploye the remuneration employe
     */
    public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

    /**
     * Gets periode.
     *
     * @return the periode
     */
    public Periode getPeriode() {
		return periode;
	}

    /**
     * Sets periode.
     *
     * @param periode the periode
     */
    public void setPeriode(Periode periode) {
		this.periode = periode;
	}

    /**
     * Gets prime exceptionnelle.
     *
     * @return the prime exceptionnelle
     */
    public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

    /**
     * Sets prime exceptionnelle.
     *
     * @param primeExceptionnelle the prime exceptionnelle
     */
    public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
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
