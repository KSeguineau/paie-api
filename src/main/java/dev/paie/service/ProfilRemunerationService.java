package dev.paie.service;

import dev.paie.entites.ProfilRemuneration;
import dev.paie.exception.ProfilInconnu;
import dev.paie.repository.ProfilRemunerationEmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilRemunerationService {

    private ProfilRemunerationEmployeRepository profilRemunerationEmployeRepository;

    public ProfilRemunerationService(ProfilRemunerationEmployeRepository profilRemunerationEmployeRepository) {
        this.profilRemunerationEmployeRepository = profilRemunerationEmployeRepository;
    }

    public List<ProfilRemuneration> findProfilRemuneration(){
        return profilRemunerationEmployeRepository.findAll();
    }

    public ProfilRemuneration findByCode(String codeProfil) {
        return profilRemunerationEmployeRepository.findByCode(codeProfil).orElseThrow(ProfilInconnu::new);
    }
}
