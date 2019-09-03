package dev.paie.service;

import dev.paie.entites.Periode;
import dev.paie.repository.PeriodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodeService {

    private PeriodeRepository periodeRepository;

    public PeriodeService(PeriodeRepository periodeRepository) {
        this.periodeRepository = periodeRepository;
    }

    public List<Periode> findPeriode(){
        return periodeRepository.findAll();
    }
}
