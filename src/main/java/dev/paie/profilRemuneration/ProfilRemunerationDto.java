package dev.paie.profilRemuneration;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilRemunerationDto {
    private String code;

    public ProfilRemunerationDto(ProfilRemuneration profilRemuneration) {
        this.code = profilRemuneration.getCode();
    }
}
