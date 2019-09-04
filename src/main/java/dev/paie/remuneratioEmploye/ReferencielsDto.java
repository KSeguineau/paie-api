package dev.paie.remuneratioEmploye;

import dev.paie.entreprise.EntrepriseDto;
import dev.paie.grade.GradeDto;
import dev.paie.profilRemuneration.ProfilRemunerationDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
