package dev.paie.controller;

import dev.paie.controller.dto.ReferencielsDto;
import dev.paie.service.ReferencielsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReferencielsController {

    private ReferencielsService referencielsService;

    public ReferencielsController(ReferencielsService referencielsService) {
        this.referencielsService = referencielsService;
    }

    @GetMapping("/referenciels")
    public ReferencielsDto findReferenciels(){
        return referencielsService.findReferenciels();
    }
}
