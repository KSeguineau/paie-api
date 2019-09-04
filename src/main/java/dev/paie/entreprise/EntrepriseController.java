package dev.paie.entreprise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return entrepriseService.findEntreprise();
    }
}
