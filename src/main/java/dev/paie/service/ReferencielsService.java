package dev.paie.service;

import dev.paie.controller.dto.ReferencielsDto;
import dev.paie.entites.ProfilRemuneration;
import org.springframework.stereotype.Service;

@Service
public class ReferencielsService {

    private EntrepriseService entrepriseService;
    private ProfilRemunerationService profilRemunerationService;
    private GradeService gradeService;

    public ReferencielsService(EntrepriseService entrepriseService, ProfilRemunerationService profilRemunerationService, GradeService gradeService) {
        this.entrepriseService = entrepriseService;
        this.profilRemunerationService = profilRemunerationService;
        this.gradeService = gradeService;
    }

public ReferencielsDto findReferenciels(){
        return new ReferencielsDto(entrepriseService.findEntreprise(),gradeService.findGrades(),profilRemunerationService.findProfilRemuneration());
}
}
