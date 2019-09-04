package dev.paie.repository;

import dev.paie.controller.dto.EntrepriseDto;
import dev.paie.entites.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * The interface Entreprise repository.
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {

     Optional<Entreprise> findByCode(String code);

     @Query("select new dev.paie.controller.dto.EntrepriseDto(e.code,e.denomination) from Entreprise e")
     List<EntrepriseDto> findAllEntreprise();


}
