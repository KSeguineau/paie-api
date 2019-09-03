package dev.paie.repository;

import dev.paie.controller.dto.GradeDto;
import dev.paie.entites.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade,Integer> {

    Optional<Grade> findByCode(String code);

    @Query("select new GradeDto(g.code,g.tauxBase,g.nbHeuresBase) from Grade g")
    List<GradeDto> findAllGrade();

}
