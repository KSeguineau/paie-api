package dev.paie.periode;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Periode.
 */
@Entity
public class Periode {
    /**
     * id de la periode
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * date de début de la période
     */
    private LocalDate dateDebut;
    /**
     * date de fin de la période
     */
    private LocalDate dateFin;

    /**
     * Gets date debut.
     *
     * @return the date debut
     */
    public LocalDate getDateDebut() {
        return dateDebut;
    }

    /**
     * Sets date debut.
     *
     * @param dateDebut the date debut
     */
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Gets date fin.
     *
     * @return the date fin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Sets date fin.
     *
     * @param dateFin the date fin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
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
