package dev.paie.repository;

import dev.paie.entites.Entreprise;
import dev.paie.entites.RemunerationEmploye;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye,Integer> {

    public Optional<RemunerationEmploye> findByMatricule(String matricule);
}
