package dev.paie.remuneratioEmploye;

import dev.paie.profilRemuneration.AjoutEmployeDto;
import dev.paie.remuneratioEmploye.api_collegue_entity.CookieNonTrouveException;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.HttpCookie;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;


@RestController
@RequestMapping("/remuneration_employe")
public class RemunerationEmployeController {

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    private RemunerationEmployeService remunerationEmployeService;

    public RemunerationEmployeController(RemunerationEmployeService remunerationEmployeService) {
        this.remunerationEmployeService = remunerationEmployeService;
    }

    @PostMapping
    public RemunerationEmployeDto ajouterEmploye(@Valid @RequestBody AjoutEmployeDto ajoutEmployeDto, HttpServletRequest req) throws URISyntaxException {

        Cookie cookie = Stream.of(req.getCookies()).filter(c -> c.getName().equals(TOKEN_COOKIE)).findFirst().orElseThrow(CookieNonTrouveException::new);
        HttpCookie httpCookie = new HttpCookie(cookie.getName(),cookie.getValue());
        httpCookie.setHttpOnly(true);
        httpCookie.setMaxAge(cookie.getMaxAge());
        httpCookie.setDomain(cookie.getDomain());
        return new RemunerationEmployeDto(remunerationEmployeService.ajouterEmploye(ajoutEmployeDto,httpCookie));
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
