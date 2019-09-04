package dev.paie.remuneratioEmploye;

import dev.paie.entreprise.EntrepriseService;
import dev.paie.grade.GradeService;
import dev.paie.profilRemuneration.ProfilRemunerationService;
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
