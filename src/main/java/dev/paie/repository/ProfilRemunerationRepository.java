package dev.paie.repository;

import dev.paie.controller.dto.ProfilRemunerationDto;
import dev.paie.entites.ProfilRemuneration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProfilRemunerationRepository extends JpaRepository<ProfilRemuneration,Integer> {

     Optional<ProfilRemuneration> findByCode(String code);

     @Query("select new dev.paie.controller.dto.ProfilRemunerationDto(p.code) from ProfilRemuneration p")
    List<ProfilRemunerationDto> findAllProfilRemuneration();
}
