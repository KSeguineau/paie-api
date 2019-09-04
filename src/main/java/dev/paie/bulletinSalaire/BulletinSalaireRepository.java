package dev.paie.bulletinSalaire;



import org.springframework.data.jpa.repository.JpaRepository;


public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire,Integer> {

    BulletinSalaire findByCode(String code);


}
