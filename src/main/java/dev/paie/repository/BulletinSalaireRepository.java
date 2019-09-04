package dev.paie.repository;

import dev.paie.controller.dto.BulletinSalaireDto;
import dev.paie.entites.BulletinSalaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire,Integer> {


}
