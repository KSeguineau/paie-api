package dev.paie.controller.dto;

import dev.paie.entites.Entreprise;
import dev.paie.entites.Grade;
import dev.paie.entites.ProfilRemuneration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ReferencielsDto {

    private List<EntrepriseDto> listEntrepriseDto;
    private List<GradeDto> listGradeDto;
    private List<ProfilRemunerationDto> listProfilRemunerationDto;

    public ReferencielsDto(List<EntrepriseDto> entreprises, List<GradeDto> grades, List<ProfilRemunerationDto> profilRemunerations) {
        this.listEntrepriseDto = entreprises;
        this.listGradeDto = grades;
        this.listProfilRemunerationDto = profilRemunerations;
    }
}
