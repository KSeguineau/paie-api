package dev.paie.controller;

import dev.paie.controller.dto.AjoutEmployeDto;
import dev.paie.controller.dto.RemunerationEmployeDto;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.service.RemunerationEmployeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

//TODO
@RestController
public class RemunerationEmployeController {

    private RemunerationEmployeService remunerationEmployeService;

    public RemunerationEmployeController(RemunerationEmployeService remunerationEmployeService) {
        this.remunerationEmployeService = remunerationEmployeService;
    }

    @PostMapping("/remuneration_employe")
    public RemunerationEmployeDto ajouterEmploye( @RequestBody AjoutEmployeDto ajoutEmployeDto){
        return new RemunerationEmployeDto(remunerationEmployeService.ajouterEmploye(ajoutEmployeDto));
    }

    @GetMapping("/remuneration_employe")
    public List<RemunerationEmployeDto> findRemunerationEmploye(){
        return remunerationEmployeService.findRemunerationEmploye().stream().map(RemunerationEmployeDto::new).collect(Collectors.toList());
    }
}
