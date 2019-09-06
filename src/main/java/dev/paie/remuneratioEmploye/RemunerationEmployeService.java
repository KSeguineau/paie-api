package dev.paie.remuneratioEmploye;

import dev.paie.profilRemuneration.AjoutEmployeDto;
import dev.paie.remuneratioEmploye.api_collegue_entity.Collegue;
import dev.paie.entreprise.EntrepriseService;
import dev.paie.profilRemuneration.MatriculeInconnuException;
import dev.paie.grade.GradeService;
import dev.paie.profilRemuneration.ProfilRemunerationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.validation.Validator;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Service
public class RemunerationEmployeService {

    private RemunerationEmployeRepository remunerationEmployeRepository;
    private EntrepriseService entrepriseService;
    private GradeService gradeService;
    private ProfilRemunerationService profilRemunerationService;
    private Validator validator;

    @Value("${urlBaseCollegueApi}")
    private String urlApiCollegue;

    private RestTemplate rt = new RestTemplate();


    public RemunerationEmployeService(RemunerationEmployeRepository remunerationEmployeRepository, EntrepriseService entrepriseService, GradeService gradeService, ProfilRemunerationService profilRemunerationService, Validator validator) {
        this.remunerationEmployeRepository = remunerationEmployeRepository;
        this.entrepriseService = entrepriseService;
        this.gradeService = gradeService;
        this.profilRemunerationService = profilRemunerationService;
        this.validator = validator;
    }

    public RemunerationEmploye ajouterEmploye(AjoutEmployeDto ajoutEmployeDto, HttpCookie cookie) throws URISyntaxException {
        RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
        ResponseEntity<Collegue> responseEntity = rt.exchange(RequestEntity.get(new URI(urlApiCollegue + "/collegues/"+ ajoutEmployeDto.getMatricule())).header(HttpHeaders.COOKIE,cookie.toString()).build(),Collegue.class);
         Collegue collegue = responseEntity.getBody();
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

    public List<RemunerationEmployeDto> findRemunerationEmploye() {
        return remunerationEmployeRepository.findAllRemunerationEmploye();
    }

    public List<String> findMatricules(){
        return remunerationEmployeRepository.findMatricule();
    }
}
