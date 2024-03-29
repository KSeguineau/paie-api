package dev.paie.grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade,Integer> {

    Optional<Grade> findByCode(String code);

    @Query("select new dev.paie.grade.GradeDto(g.code,g.tauxBase,g.nbHeuresBase) from Grade g")
    List<GradeDto> findAllGrade();

}
