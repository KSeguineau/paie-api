package dev.paie;

import dev.paie.Authentification.CollegueConnecteService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Value("${jwt.secret}")
    private String SECRET;


    private CollegueConnecteService collegueConnecteService = new CollegueConnecteService();

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        if(req.getCookies() != null) {
            Stream.of(req.getCookies()).filter(cookie -> cookie.getName().equals(TOKEN_COOKIE))
                    .map(Cookie::getValue)
                    .forEach(token -> {
                        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();

                        collegueConnecteService.setUsername(body.getSubject());
                        collegueConnecteService.setMatricule(body.get("matricule",String.class));
                        List<String> roles = body.get("roles",List.class);
                        List<SimpleGrantedAuthority> authorities = roles
                                .stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList());
                        Authentication authentication = new UsernamePasswordAuthenticationToken(collegueConnecteService, null, authorities);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    });
        }


        chain.doFilter(req, res);
    }
}
