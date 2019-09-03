package dev.paie.service;

import dev.paie.repository.RemunerationEmployeRepository;
import org.springframework.stereotype.Service;
//TODO
@Service
public class RemunerationEmployeService {

    private RemunerationEmployeRepository remunerationEmployeRepository;

    public RemunerationEmployeService(RemunerationEmployeRepository remunerationEmployeRepository) {
        this.remunerationEmployeRepository = remunerationEmployeRepository;
    }


}
