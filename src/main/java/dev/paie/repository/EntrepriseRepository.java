package dev.paie.repository;

import dev.paie.entites.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Entreprise repository.
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {

}
