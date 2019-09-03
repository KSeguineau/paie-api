package dev.paie.repository;

import dev.paie.entites.Entreprise;
import dev.paie.entites.RemunerationEmploye;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye,Integer> {
}
