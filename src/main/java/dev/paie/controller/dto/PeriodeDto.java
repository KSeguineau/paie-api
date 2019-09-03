package dev.paie.controller.dto;

import dev.paie.entites.Periode;
import dev.paie.service.PeriodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeriodeDto {

    private PeriodeService periodeService;

    public PeriodeDto(PeriodeService periodeService) {
        this.periodeService = periodeService;
    }

    @GetMapping("/periodes")
    public List<Periode> findPeriode(){
       return periodeService.findPeriode();
    }
}
