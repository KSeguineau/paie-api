package dev.paie.Authentification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegueConnecteService {

    private String username;
    private String matricule;
}
