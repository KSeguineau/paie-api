package dev.paie.profilRemuneration;

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
