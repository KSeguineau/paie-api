package dev.paie.service;

import dev.paie.controller.dto.AjoutBulletinSalaire;
import dev.paie.controller.dto.BulletinSansSalaireDto;
import dev.paie.controller.dto.SalaireDto;
import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Cotisation;
import dev.paie.exception.BulletionSalaireIncompletException;
import dev.paie.exception.MatriculeInconnuException;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class BulletinSalaireService {

    private BulletinSalaireRepository bulletinSalaireRepository;
    private RemunerationEmployeRepository remunerationEmployeRepository;
    private Validator validator;

    public BulletinSalaireService(BulletinSalaireRepository bulletinSalaireRepository, RemunerationEmployeRepository remunerationEmployeRepository, Validator validator) {
        this.bulletinSalaireRepository = bulletinSalaireRepository;
        this.remunerationEmployeRepository = remunerationEmployeRepository;
        this.validator = validator;
    }

    public BulletinSansSalaireDto ajouterBulletinSalaire(AjoutBulletinSalaire ajoutBulletinSalaire) {
        BulletinSalaire bulletinSalaire = new BulletinSalaire();
        bulletinSalaire.setRemunerationEmploye(remunerationEmployeRepository.findByMatricule(ajoutBulletinSalaire.getMatricule()).orElseThrow(MatriculeInconnuException::new));
        bulletinSalaire.setPeriode(ajoutBulletinSalaire.getPeriode());
        bulletinSalaire.setPrimeExceptionnelle(ajoutBulletinSalaire.getPrimeExceptionnelle());
        if(validator.validate(bulletinSalaire).isEmpty()){
            bulletinSalaireRepository.save(bulletinSalaire);
            return new BulletinSansSalaireDto(bulletinSalaire);
        }
        else{
            throw new BulletionSalaireIncompletException();
        }
    }

    public List<BulletinSalaire> findBulletinSalaire(){
        return bulletinSalaireRepository.findAll();
    }

    public SalaireDto calculSalaire(BulletinSalaire bulletinSalaire){
        BigDecimal salaireBrut = this.calculSalaireBrut(bulletinSalaire);
        BigDecimal salaireNetImposable = this.calculNetImposable(bulletinSalaire,salaireBrut);
        BigDecimal salaireNetAPayer = this.calculNetAPayer(bulletinSalaire,salaireBrut,salaireNetImposable);
        return new SalaireDto(salaireBrut,salaireNetImposable,salaireNetAPayer);
    }

    private BigDecimal calculSalaireBrut(BulletinSalaire bulletinSalaire){
        BigDecimal tauxHoraire = bulletinSalaire.getRemunerationEmploye().getGrade().getTauxBase();
        BigDecimal nbHeures = bulletinSalaire.getRemunerationEmploye().getGrade().getNbHeuresBase();
        BigDecimal primeExceptionnelle = bulletinSalaire.getPrimeExceptionnelle();
        BigDecimal salaireBrut = tauxHoraire.multiply(nbHeures).add(primeExceptionnelle);
        return salaireBrut.setScale(2, RoundingMode.HALF_UP);

    }

    private BigDecimal calculNetImposable(BulletinSalaire bulletinSalaire,BigDecimal salaireBrut){
        List<Cotisation> listeCotisation = bulletinSalaire.getRemunerationEmploye().getProfilRemuneration().getCotisations();
        BigDecimal salaireNetImposable = salaireBrut;

        for(Cotisation cotisation : listeCotisation){
            if(cotisation.getTauxSalarial()!=null&&!cotisation.getImposable()){
                salaireNetImposable = salaireNetImposable.subtract(salaireBrut.multiply(cotisation.getTauxSalarial()));
            }
        }

        return salaireNetImposable.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculNetAPayer(BulletinSalaire bulletinSalaire,BigDecimal salaireBrut,BigDecimal salaireNetImposable){
        List<Cotisation> listeCotisation = bulletinSalaire.getRemunerationEmploye().getProfilRemuneration().getCotisations();
        BigDecimal salaireNetAPayer = salaireNetImposable;
        for(Cotisation cotisation : listeCotisation){
            if(cotisation.getTauxSalarial()!=null&&cotisation.getImposable()){
                salaireNetAPayer = salaireNetAPayer.subtract(salaireBrut.multiply(cotisation.getTauxSalarial()));
            }
        }
        return salaireNetAPayer.setScale(2, RoundingMode.HALF_UP);
    }
}
