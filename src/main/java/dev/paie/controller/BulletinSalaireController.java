package dev.paie.controller;

import dev.paie.controller.dto.AjoutBulletinSalaire;
import dev.paie.controller.dto.BulletinSalaireDto;
import dev.paie.entites.BulletinSalaire;
import dev.paie.service.BulletinSalaireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BulletinSalaireController {

    private BulletinSalaireService bulletinSalaireService;

    public BulletinSalaireController(BulletinSalaireService bulletinSalaireService) {
        this.bulletinSalaireService = bulletinSalaireService;
    }

    @PostMapping("/bulletin_salaire")
    public BulletinSalaireDto ajoutBulletinSalaire( @RequestBody AjoutBulletinSalaire ajoutBulletinSalaire){
        BulletinSalaire bulletinSalaire = bulletinSalaireService.ajouterBulletinSalaire(ajoutBulletinSalaire);
        return new BulletinSalaireDto(bulletinSalaire,bulletinSalaireService.calculSalaire(bulletinSalaire));
    }

    @GetMapping("/bulletin_salaire")
    public List<BulletinSalaireDto> findBulletinSalaire(){
        List<BulletinSalaire> listeBulletinSalaire = bulletinSalaireService.findBulletinSalaire();
        List<BulletinSalaireDto> listeBulletinSalaireDto = new ArrayList<>();

        for(BulletinSalaire bulletinSalaire: listeBulletinSalaire){
            listeBulletinSalaireDto.add(new BulletinSalaireDto(bulletinSalaire,bulletinSalaireService.calculSalaire(bulletinSalaire)));
        }
       return listeBulletinSalaireDto;
    }


}
