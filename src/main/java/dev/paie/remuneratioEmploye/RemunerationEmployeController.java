package dev.paie.remuneratioEmploye;

import dev.paie.profilRemuneration.AjoutEmployeDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/remuneration_employe")
public class RemunerationEmployeController {

    private RemunerationEmployeService remunerationEmployeService;

    public RemunerationEmployeController(RemunerationEmployeService remunerationEmployeService) {
        this.remunerationEmployeService = remunerationEmployeService;
    }

    @PostMapping
    public RemunerationEmployeDto ajouterEmploye(@Valid @RequestBody AjoutEmployeDto ajoutEmployeDto){
        return new RemunerationEmployeDto(remunerationEmployeService.ajouterEmploye(ajoutEmployeDto));
    }

    @GetMapping
    public List<RemunerationEmployeDto> findRemunerationEmploye(){
        return remunerationEmployeService.findRemunerationEmploye();
    }

    @GetMapping(params = "matricules")
    public List<String> findMatricule(){
       return remunerationEmployeService.findMatricules();
    }
}
