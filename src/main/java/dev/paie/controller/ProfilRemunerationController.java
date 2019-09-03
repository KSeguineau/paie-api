package dev.paie.controller;

import dev.paie.controller.dto.ProfilRemunerationDto;
import dev.paie.service.ProfilRemunerationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//TODO
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
