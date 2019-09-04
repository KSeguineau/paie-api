package dev.paie.periode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeriodeController {

    private PeriodeService periodeService;

    public PeriodeController(PeriodeService periodeService) {
        this.periodeService = periodeService;
    }

    @GetMapping("/periodes")
    public List<Periode> findPeriode(){
       return periodeService.findPeriode();
    }
}
