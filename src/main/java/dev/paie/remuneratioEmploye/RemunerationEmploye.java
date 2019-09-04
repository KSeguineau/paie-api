package dev.paie.remuneratioEmploye;


import dev.paie.entreprise.Entreprise;
import dev.paie.grade.Grade;
import dev.paie.profilRemuneration.ProfilRemuneration;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

/**
 * The type Remuneration employe.
 */
@Entity
@Data
public class RemunerationEmploye {

    /**
     * id de la remuneration de l’employe
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * matricule de l’employe
     */
    @NotNull
    @Column(unique = true)
    private String matricule;

    /**
     * entreprise de l’employe
     */
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    @NotNull
    private Entreprise entreprise;
    /**
     * profil de rémuneration de l’employé
     */
    @ManyToOne
    @JoinColumn(name = "profil_remuneration_id")
    @NotNull
    private ProfilRemuneration profilRemuneration;
    /**
     * grade de l’employé
     */
    @ManyToOne
    @JoinColumn(name = "grade_id")
    @NotNull
    private Grade grade;

    private ZonedDateTime dateCreation;

    @PrePersist
    public void dateCreation(){
        dateCreation = ZonedDateTime.now();
    }

    /**
     * Gets matricule.
     *
     * @return the matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * Sets matricule.
     *
     * @param matricule the matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * Gets entreprise.
     *
     * @return the entreprise
     */
    public Entreprise getEntreprise() {
        return entreprise;
    }

    /**
     * Sets entreprise.
     *
     * @param entreprise the entreprise
     */
    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    /**
     * Gets profil remuneration.
     *
     * @return the profil remuneration
     */
    public ProfilRemuneration getProfilRemuneration() {
        return profilRemuneration;
    }

    /**
     * Sets profil remuneration.
     *
     * @param profilRemuneration the profil remuneration
     */
    public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
        this.profilRemuneration = profilRemuneration;
    }

    /**
     * Gets grade.
     *
     * @return the grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * Sets grade.
     *
     * @param grade the grade
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
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
