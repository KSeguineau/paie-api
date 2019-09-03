package dev.paie.repository;

import dev.paie.entites.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Entreprise repository.
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {

    public Optional<Entreprise> findByCode(String code);

}
