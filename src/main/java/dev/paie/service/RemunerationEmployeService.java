package dev.paie.service;

import dev.paie.controller.dto.AjoutEmployeDto;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.entites.api_collegue_entity.Collegue;
import dev.paie.exception.MatriculeInconnuException;
import dev.paie.exception.RemunerationEmployeIncompletException;
import dev.paie.repository.RemunerationEmployeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Validator;
import java.util.List;

//TODO
@Service
public class RemunerationEmployeService {

    private RemunerationEmployeRepository remunerationEmployeRepository;
    private EntrepriseService entrepriseService;
    private GradeService gradeService;
    private ProfilRemunerationService profilRemunerationService;
    private Validator validator;

    @Value("${urlBase}")
    private String urlApiCollegue;

    private RestTemplate rt = new RestTemplate();


    public RemunerationEmployeService(RemunerationEmployeRepository remunerationEmployeRepository, EntrepriseService entrepriseService, GradeService gradeService, ProfilRemunerationService profilRemunerationService, Validator validator) {
        this.remunerationEmployeRepository = remunerationEmployeRepository;
        this.entrepriseService = entrepriseService;
        this.gradeService = gradeService;
        this.profilRemunerationService = profilRemunerationService;
        this.validator = validator;
    }

    public RemunerationEmploye ajouterEmploye(AjoutEmployeDto ajoutEmployeDto) {
        RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
        Collegue collegue = rt.getForObject(urlApiCollegue + "/collegues/" + ajoutEmployeDto.getMatricule(), Collegue.class, 1);
        if (collegue != null) {
            remunerationEmploye.setMatricule(collegue.getMatricule());
            remunerationEmploye.setEntreprise(entrepriseService.findByCode(ajoutEmployeDto.getCodeEntreprise()));
            remunerationEmploye.setGrade(gradeService.findByCode(ajoutEmployeDto.getCodeGrade()));
            remunerationEmploye.setProfilRemuneration(profilRemunerationService.findByCode(ajoutEmployeDto.getCodeProfil()));

            if (validator.validate(remunerationEmploye).isEmpty()) {
                return remunerationEmployeRepository.save(remunerationEmploye);
            } else {
                throw new RemunerationEmployeIncompletException();
            }
        } else {
            throw new MatriculeInconnuException();
        }

    }

    public List<RemunerationEmploye> findRemunerationEmploye() {
        return remunerationEmployeRepository.findAll();
    }
}
