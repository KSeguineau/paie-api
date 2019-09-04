package dev.paie.profilRemuneration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProfilRemunerationController {

    private ProfilRemunerationService profilRemunerationService;

    public ProfilRemunerationController(ProfilRemunerationService profilRemunerationService) {
        this.profilRemunerationService = profilRemunerationService;
    }

    @GetMapping("/profils_remunerations")
    public List<ProfilRemunerationDto> findProfilRemuneration(){
        return profilRemunerationService.findProfilRemuneration();
    }
}
