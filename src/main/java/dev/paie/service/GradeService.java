package dev.paie.service;

import dev.paie.entites.Grade;
import dev.paie.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> findGrades(){
       return gradeRepository.findAll();
    }
}
