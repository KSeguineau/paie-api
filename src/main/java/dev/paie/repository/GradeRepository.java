package dev.paie.repository;

import dev.paie.entites.Entreprise;
import dev.paie.entites.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Integer> {
}
