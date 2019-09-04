package dev.paie.service;

import dev.paie.controller.dto.AjoutBulletinSalaire;
import dev.paie.controller.dto.BulletinSansSalaireDto;
import dev.paie.controller.dto.SalaireDto;
import dev.paie.controller.dto.VisualisationBulletinSalaireDto;
import dev.paie.controller.dto.dtoVisualisationBulletinSalaire.*;
import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Cotisation;
import dev.paie.entites.Entreprise;
import dev.paie.entites.api_collegue_entity.Collegue;
import dev.paie.exception.BulletionSalaireIncompletException;
import dev.paie.exception.CalculTotalException;
import dev.paie.exception.MatriculeInconnuException;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Validator;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BulletinSalaireService {

    private BulletinSalaireRepository bulletinSalaireRepository;
    private RemunerationEmployeRepository remunerationEmployeRepository;
    private Validator validator;
    RestTemplate rt = new RestTemplate();
    @Value("${urlBase}")
    private String urlApiCollegue;

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

    public VisualisationBulletinSalaireDto findVisualisationBulletinSalaire(String code){
        BulletinSalaire bulletinSalaire= bulletinSalaireRepository.findByCode(code);
        Entreprise entreprise = bulletinSalaire.getRemunerationEmploye().getEntreprise();
        VisualisationEntreprisDto visualisationEntreprisDto = new VisualisationEntreprisDto(entreprise.getDenomination(),entreprise.getSiret());

        Collegue collegue = rt.getForObject(urlApiCollegue+"/collegues/"+bulletinSalaire.getRemunerationEmploye().getMatricule(), Collegue.class, 1);

        VisualisationCollegueDto visualisationCollegueDto = new VisualisationCollegueDto(collegue.getMatricule(),collegue.getNom(),collegue.getPrenom(),collegue.getDdn());

        VisualisationPeriodeDto visualisationPeriodeDto = new VisualisationPeriodeDto(bulletinSalaire.getPeriode().getDateDebut(),bulletinSalaire.getPeriode().getDateFin());

        List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList = creationListLigneSalaire(bulletinSalaire);
        BigDecimal salaireBrut = ligneBulletinSalaireDtoList.stream().filter(v -> v.getMontantSalarial()!=null).map(VisualisationLigneBulletinSalaireDto::getMontantSalarial).reduce(BigDecimal::add).orElseThrow(CalculTotalException::new);
        VisualisationSalaireDto visualisationSalaireDto = new VisualisationSalaireDto(ligneBulletinSalaireDtoList,salaireBrut);


        ligneBulletinSalaireDtoList = creationListLigneCotisationNonImposable(bulletinSalaire,salaireBrut);
        BigDecimal totalRetenueSalarial = ligneBulletinSalaireDtoList.stream().filter(l -> l.getMontantSalarial()!=null).map(VisualisationLigneBulletinSalaireDto::getMontantSalarial).reduce(BigDecimal::add).orElseThrow(CalculTotalException::new);
        BigDecimal totalRetenuePatronale = ligneBulletinSalaireDtoList.stream().filter(l -> l.getCotisationPatronale()!=null).map(VisualisationLigneBulletinSalaireDto::getCotisationPatronale).reduce(BigDecimal::add).orElseThrow(CalculTotalException::new);
        BigDecimal salaireNetImposable = salaireBrut.subtract(totalRetenueSalarial).setScale(2,RoundingMode.HALF_UP);
        VisualisationCotisationNonImposableDto visualisationCotisationNonImposableDto = new VisualisationCotisationNonImposableDto(ligneBulletinSalaireDtoList,totalRetenueSalarial,totalRetenuePatronale,salaireNetImposable);

        ligneBulletinSalaireDtoList = creationListLigneCotisationImposable(bulletinSalaire,salaireBrut);
        BigDecimal totalRetenueImposable = ligneBulletinSalaireDtoList.stream().filter(l -> l.getMontantSalarial()!=null).map(VisualisationLigneBulletinSalaireDto::getMontantSalarial).reduce(BigDecimal::add).orElseThrow(CalculTotalException::new);
        BigDecimal salaireNetAPayer = salaireNetImposable.subtract(totalRetenueImposable).setScale(2,RoundingMode.HALF_UP);
        VisualisationCotisationsImposableDto visualisationCotisationsImposableDto = new VisualisationCotisationsImposableDto(ligneBulletinSalaireDtoList,salaireNetAPayer);

        return new VisualisationBulletinSalaireDto(visualisationEntreprisDto,visualisationPeriodeDto,visualisationCollegueDto,visualisationSalaireDto,visualisationCotisationNonImposableDto,visualisationCotisationsImposableDto);

    }



    private List<VisualisationLigneBulletinSalaireDto> creationListLigneSalaire(BulletinSalaire bulletinSalaire){
        List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList = new ArrayList<>();

        VisualisationLigneBulletinSalaireDto visualisationLigneBulletinSalaireDto = new VisualisationLigneBulletinSalaireDto();
        visualisationLigneBulletinSalaireDto.setRubriques("salaire de base");
        visualisationLigneBulletinSalaireDto.setBase(bulletinSalaire.getRemunerationEmploye().getGrade().getNbHeuresBase());
        visualisationLigneBulletinSalaireDto.setTauxSalarial(bulletinSalaire.getRemunerationEmploye().getGrade().getTauxBase());
        calculerMontants(visualisationLigneBulletinSalaireDto);
        ligneBulletinSalaireDtoList.add(visualisationLigneBulletinSalaireDto);

        visualisationLigneBulletinSalaireDto = new VisualisationLigneBulletinSalaireDto();
        visualisationLigneBulletinSalaireDto.setRubriques("prime Except.");
        visualisationLigneBulletinSalaireDto.setMontantSalarial(bulletinSalaire.getPrimeExceptionnelle().setScale(2,RoundingMode.HALF_UP));
        ligneBulletinSalaireDtoList.add(visualisationLigneBulletinSalaireDto);

        return ligneBulletinSalaireDtoList;

    }

    private void calculerMontants(VisualisationLigneBulletinSalaireDto visualisationLigneBulletinSalaireDto){
        if(visualisationLigneBulletinSalaireDto.getBase()!=null&&visualisationLigneBulletinSalaireDto.getTauxSalarial()!=null){
            visualisationLigneBulletinSalaireDto.setMontantSalarial((visualisationLigneBulletinSalaireDto.getBase().multiply(visualisationLigneBulletinSalaireDto.getTauxSalarial()).setScale(2,RoundingMode.HALF_UP)));
        }
        if(visualisationLigneBulletinSalaireDto.getBase()!=null&&visualisationLigneBulletinSalaireDto.getTauxPatronal()!=null){
            visualisationLigneBulletinSalaireDto.setCotisationPatronale(visualisationLigneBulletinSalaireDto.getBase().multiply(visualisationLigneBulletinSalaireDto.getTauxPatronal()).setScale(2,RoundingMode.HALF_UP));
        }
    }

    private List<VisualisationLigneBulletinSalaireDto> creationListLigneCotisationNonImposable(BulletinSalaire bulletinSalaire,BigDecimal salaireBrut){
        List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList = new ArrayList<>();
        for(Cotisation cotisation:bulletinSalaire.getRemunerationEmploye().getProfilRemuneration().getCotisations().stream().filter(c -> !c.getImposable()).collect(Collectors.toList())){
        VisualisationLigneBulletinSalaireDto visualisationLigneBulletinSalaireDto = new VisualisationLigneBulletinSalaireDto();
        visualisationLigneBulletinSalaireDto.setRubriques(cotisation.getLibelle());
        visualisationLigneBulletinSalaireDto.setBase(salaireBrut);
        visualisationLigneBulletinSalaireDto.setTauxSalarial(cotisation.getTauxSalarial());
        visualisationLigneBulletinSalaireDto.setTauxPatronal(cotisation.getTauxPatronal());
        calculerMontants(visualisationLigneBulletinSalaireDto);
        ligneBulletinSalaireDtoList.add(visualisationLigneBulletinSalaireDto);
        }
        return ligneBulletinSalaireDtoList;
    }

    private List<VisualisationLigneBulletinSalaireDto> creationListLigneCotisationImposable(BulletinSalaire bulletinSalaire, BigDecimal salaireBrut) {
        List<VisualisationLigneBulletinSalaireDto> ligneBulletinSalaireDtoList = new ArrayList<>();
        for(Cotisation cotisation:bulletinSalaire.getRemunerationEmploye().getProfilRemuneration().getCotisations().stream().filter(Cotisation::getImposable).collect(Collectors.toList())){
            VisualisationLigneBulletinSalaireDto visualisationLigneBulletinSalaireDto = new VisualisationLigneBulletinSalaireDto();
            visualisationLigneBulletinSalaireDto.setRubriques(cotisation.getLibelle());
            visualisationLigneBulletinSalaireDto.setBase(salaireBrut);
            visualisationLigneBulletinSalaireDto.setTauxSalarial(cotisation.getTauxSalarial());
            visualisationLigneBulletinSalaireDto.setTauxPatronal(cotisation.getTauxPatronal());
            calculerMontants(visualisationLigneBulletinSalaireDto);
            ligneBulletinSalaireDtoList.add(visualisationLigneBulletinSalaireDto);
        }
        return ligneBulletinSalaireDtoList;
    }
}

