package dev.paie.bulletinSalaire;

import dev.paie.periode.Periode;
import dev.paie.remuneratioEmploye.RemunerationEmploye;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;


/**
 * Represente le bulletin de salaire.
 */
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames = {"remuneration_employe_id", "periode_id"})
})
@Entity
@Data
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
	@ManyToOne
	@NotNull
		@JoinColumn(name = "remuneration_employe_id")
	private RemunerationEmploye remunerationEmploye;

    /**
     * represente la période de travail correspondant au salaire
     */
	@ManyToOne
	@JoinColumn(name="periode_id")
	@NotNull
	private Periode periode;

    /**
     * represente le montant de la prime exceptionnelle
     */
	@Column(precision = 25,scale = 6)
	private BigDecimal primeExceptionnelle;

	private ZonedDateTime dateCreation;

	private String code;

	@PrePersist
	public void prepersist(){
		dateCreation = ZonedDateTime.now();
		code = UUID.randomUUID().toString();
	}



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
