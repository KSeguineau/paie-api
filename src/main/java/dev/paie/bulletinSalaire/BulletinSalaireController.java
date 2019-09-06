package dev.paie.bulletinSalaire;

import dev.paie.Authentification.CollegueConnecteService;
import dev.paie.bulletinSalaire.dto.AjoutBulletinSalaireDto;
import dev.paie.bulletinSalaire.dto.BulletinSalaireDto;
import dev.paie.bulletinSalaire.dto.BulletinSansSalaireDto;
import dev.paie.bulletinSalaire.dto.VisualisationBulletinSalaireDto;
import dev.paie.remuneratioEmploye.api_collegue_entity.CookieNonTrouveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.HttpCookie;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class BulletinSalaireController {

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;
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

    @Secured("USER")
    @GetMapping("/bulletin_salaire/{code}")
    public VisualisationBulletinSalaireDto findVisualisationBulletinSalaire(@PathVariable String code, HttpServletRequest req) throws URISyntaxException {
        Cookie cookie = Stream.of(req.getCookies()).filter(c -> c.getName().equals(TOKEN_COOKIE)).findFirst().orElseThrow(CookieNonTrouveException::new);
        HttpCookie httpCookie = new HttpCookie(cookie.getName(),cookie.getValue());
        httpCookie.setHttpOnly(true);
        httpCookie.setMaxAge(cookie.getMaxAge());
        httpCookie.setDomain(cookie.getDomain());
        return bulletinSalaireService.findVisualisationBulletinSalaire( code,httpCookie);
    }

}
