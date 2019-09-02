package dev.paie.entites;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProfilRemuneration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    @ManyToMany
    @JoinTable(name = "profil_remuneration_cotisation",
            joinColumns = @JoinColumn(name = "profil_remuneration_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cotisation_id",referencedColumnName = "id"))
    private List<Cotisation> cotisations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Cotisation> getCotisations() {
        return cotisations;
    }

    public void setCotisations(List<Cotisation> cotisations) {
        this.cotisations = cotisations;
    }

}
