package dev.paie.service;

import dev.paie.entites.Entreprise;
import dev.paie.repository.EntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    public List<Entreprise> findEntreprise(){
        return entrepriseRepository.findAll();
    }
}
