package dev.paie.grade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {

    private GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/grades")
    public List<GradeDto> findGrade(){
        return gradeService.findGrades();
    }
}
