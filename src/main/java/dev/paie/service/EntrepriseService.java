package dev.paie.service;

import dev.paie.entites.Entreprise;
import dev.paie.exception.EntrepriseInconnue;
import dev.paie.repository.EntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Entreprise service.
 */
@Service
public class EntrepriseService {

    /**
     * Classe d’acces à la base de données
     */
    private EntrepriseRepository entrepriseRepository;

    /**
     * Instantiates a new Entreprise service.
     *
     * @param entrepriseRepository the entreprise repository
     */
    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    /**
     * Find entreprise list.
     *
     * @return the list
     */
    public List<Entreprise> findEntreprise() {
        return entrepriseRepository.findAll();
    }

    public Entreprise findByCode(String codeEntreprise) {
        return entrepriseRepository.findByCode(codeEntreprise).orElseThrow(EntrepriseInconnue::new);
    }
}
