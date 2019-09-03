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

    public ReferencielsDto(List<Entreprise> entreprises, List<Grade> grades, List<ProfilRemuneration> profilRemunerations) {
        this.listEntrepriseDto = entreprises.stream().map(EntrepriseDto::new).collect(Collectors.toList());
        this.listGradeDto = grades.stream().map(GradeDto::new).collect(Collectors.toList());
        this.listProfilRemunerationDto = profilRemunerations.stream().map(ProfilRemunerationDto::new).collect(Collectors.toList());
    }
}
