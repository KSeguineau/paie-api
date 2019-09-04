package dev.paie.profilRemuneration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProfilRemunerationRepository extends JpaRepository<ProfilRemuneration,Integer> {

     Optional<ProfilRemuneration> findByCode(String code);

     @Query("select new dev.paie.profilRemuneration.ProfilRemunerationDto(p.code) from ProfilRemuneration p")
    List<ProfilRemunerationDto> findAllProfilRemuneration();
}
