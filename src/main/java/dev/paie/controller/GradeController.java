package dev.paie.controller;

import dev.paie.controller.dto.GradeDto;
import dev.paie.service.GradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//TODO
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
