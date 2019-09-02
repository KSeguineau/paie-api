package dev.paie.controller;

import dev.paie.controller.dto.EntrepriseDto;
import dev.paie.entites.Entreprise;
import dev.paie.service.EntrepriseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Entreprise controller.
 */
@RestController
public class EntrepriseController {

    private EntrepriseService entrepriseService;

    /**
     * Instantiates a new Entreprise controller.
     *
     * @param entrepriseService the entreprise service
     */
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    /**
     * Find entreprise list.
     *
     * @return the list
     */
    @GetMapping("/entreprises")
    public List<EntrepriseDto> findEntreprise(){
        List<Entreprise> entreprises = entrepriseService.findEntreprise();
        return entreprises.stream().map(e -> new EntrepriseDto(e.getCode(),e.getDenomination())).collect(Collectors.toList());
    }
}
