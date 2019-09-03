package dev.paie.repository;

import dev.paie.entites.Periode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeRepository extends JpaRepository<Periode,Integer> {
}
