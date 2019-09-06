package dev.paie.Authentification;

import dev.paie.Authentification.dto.InfosAuthentificationPost;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationController {

    private AuthentificationService authentificationService;

    public AuthentificationController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> authenticate(@RequestBody InfosAuthentificationPost infos) throws JSONException {
        return authentificationService.authenticate(infos);
    }
}
