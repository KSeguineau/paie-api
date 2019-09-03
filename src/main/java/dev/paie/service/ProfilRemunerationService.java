package dev.paie.service;

import dev.paie.controller.dto.ProfilRemunerationDto;
import dev.paie.entites.ProfilRemuneration;
import dev.paie.exception.ProfilInconnuException;
import dev.paie.repository.ProfilRemunerationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilRemunerationService {

    private ProfilRemunerationRepository profilRemunerationEmployeRepository;

    public ProfilRemunerationService(ProfilRemunerationRepository profilRemunerationEmployeRepository) {
        this.profilRemunerationEmployeRepository = profilRemunerationEmployeRepository;
    }

    public List<ProfilRemunerationDto> findProfilRemuneration(){
        return profilRemunerationEmployeRepository.findAllProfilRemuneration();
    }

    public ProfilRemuneration findByCode(String codeProfil) {
        return profilRemunerationEmployeRepository.findByCode(codeProfil).orElseThrow(ProfilInconnuException::new);
    }
}
