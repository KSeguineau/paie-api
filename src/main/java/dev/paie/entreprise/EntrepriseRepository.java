package dev.paie.entreprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * The interface Entreprise repository.
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {

     Optional<Entreprise> findByCode(String code);

     @Query("select new dev.paie.entreprise.EntrepriseDto(e.code,e.denomination) from Entreprise e")
     List<EntrepriseDto> findAllEntreprise();


}
