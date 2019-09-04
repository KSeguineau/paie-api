package dev.paie.repository;


import dev.paie.entites.BulletinSalaire;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire,Integer> {

    BulletinSalaire findByCode(String code);


}
