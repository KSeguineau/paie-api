package dev.paie.Authentification;



import org.json.JSONException;
import org.json.JSONObject;
import dev.paie.Authentification.dto.InfosAuthentificationPost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthentificationService {

    RestTemplate rt = new RestTemplate();
    @Value("${urlBaseCollegueApi}")
    private String urlBaseCollegueApi;

    public ResponseEntity<?> authenticate(InfosAuthentificationPost infos) throws JSONException {
        HttpEntity<String> request = createRequestAuthenticate(infos);
        ResponseEntity responseEntity= rt.postForEntity(urlBaseCollegueApi+"/auth",request,String.class);
        responseEntity.getStatusCode();
        return responseEntity;
    }

    public HttpEntity<String>  createRequestAuthenticate(InfosAuthentificationPost infos) throws JSONException{
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject authenticateJsonObject = new JSONObject();
        authenticateJsonObject.put("login",infos.getLogin());
        authenticateJsonObject.put("mdp",infos.getMdp());
        return new HttpEntity<String>(authenticateJsonObject.toString(),headers);
    }
}
