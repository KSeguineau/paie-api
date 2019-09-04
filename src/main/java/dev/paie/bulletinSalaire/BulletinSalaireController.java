package dev.paie.bulletinSalaire;

import dev.paie.bulletinSalaire.dto.AjoutBulletinSalaireDto;
import dev.paie.bulletinSalaire.dto.BulletinSalaireDto;
import dev.paie.bulletinSalaire.dto.BulletinSansSalaireDto;
import dev.paie.bulletinSalaire.dto.VisualisationBulletinSalaireDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BulletinSalaireController {

    private BulletinSalaireService bulletinSalaireService;

    public BulletinSalaireController(BulletinSalaireService bulletinSalaireService) {
        this.bulletinSalaireService = bulletinSalaireService;
    }

    @PostMapping("/bulletin_salaire")
    public BulletinSansSalaireDto ajoutBulletinSalaire(@RequestBody AjoutBulletinSalaireDto ajoutBulletinSalaire){
        return bulletinSalaireService.ajouterBulletinSalaire(ajoutBulletinSalaire);
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

    @GetMapping("/bulletin_salaire/{code}")
    public VisualisationBulletinSalaireDto findVisualisationBulletinSalaire(@PathVariable String code){
        return bulletinSalaireService.findVisualisationBulletinSalaire( code);
    }

}