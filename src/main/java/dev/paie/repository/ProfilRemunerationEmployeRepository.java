package dev.paie.repository;

import dev.paie.entites.ProfilRemuneration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfilRemunerationEmployeRepository extends JpaRepository<ProfilRemuneration,Integer> {

    public Optional<ProfilRemuneration> findByCode(String code);
}
