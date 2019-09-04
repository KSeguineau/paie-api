package dev.paie.grade;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<GradeDto> findGrades(){
       return gradeRepository.findAllGrade();
    }

    public Grade findByCode(String codeGrade) {
        return gradeRepository.findByCode(codeGrade).orElseThrow(GradeInconnuException::new);
    }
}
