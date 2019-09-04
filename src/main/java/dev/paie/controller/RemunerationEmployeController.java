package dev.paie.controller;

import dev.paie.controller.dto.AjoutEmployeDto;
import dev.paie.controller.dto.RemunerationEmployeDto;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.service.RemunerationEmployeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

//TODO
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
