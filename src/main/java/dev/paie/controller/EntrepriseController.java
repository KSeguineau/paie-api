package dev.paie.controller;

import dev.paie.dto.EntrepriseDto;
import dev.paie.entites.Entreprise;
import dev.paie.service.EntrepriseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EntrepriseController {

    private EntrepriseService entrepriseService;

    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping("/entreprises")
    public List<EntrepriseDto> findEntreprise(){
        List<Entreprise> entreprises = entrepriseService.findEntreprise();
        return entreprises.stream().map(e -> new EntrepriseDto(e.getCode(),e.getDenomination())).collect(Collectors.toList());
    }
}
