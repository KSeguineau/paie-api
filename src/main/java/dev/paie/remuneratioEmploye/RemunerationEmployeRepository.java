package dev.paie.remuneratioEmploye;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye,Integer> {

    public Optional<RemunerationEmploye> findByMatricule(String matricule);


    @Query("select new dev.paie.remuneratioEmploye.RemunerationEmployeDto(r.matricule,r.dateCreation,r.grade.code) from RemunerationEmploye r")
    List<RemunerationEmployeDto> findAllRemunerationEmploye();

    @Query("select r.matricule from RemunerationEmploye r")
    List<String> findMatricule();
}
