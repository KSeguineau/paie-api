package dev.paie.profilRemuneration;

import javax.persistence.*;
import java.util.List;

/**
 * The type Profil remuneration.
 */
@Entity
public class ProfilRemuneration {

    /**
     * id du profil de remuneration
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * code du profil de remuneration
     */
    private String code;
    /**
     * liste des cotisations
     */
    @ManyToMany
    @JoinTable(name = "profil_remuneration_cotisation",
            joinColumns = @JoinColumn(name = "profil_remuneration_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cotisation_id", referencedColumnName = "id"))
    private List<Cotisation> cotisations;

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
     * Gets cotisations.
     *
     * @return the cotisations
     */
    public List<Cotisation> getCotisations() {
        return cotisations;
    }

    /**
     * Sets cotisations.
     *
     * @param cotisations the cotisations
     */
    public void setCotisations(List<Cotisation> cotisations) {
        this.cotisations = cotisations;
    }

}
