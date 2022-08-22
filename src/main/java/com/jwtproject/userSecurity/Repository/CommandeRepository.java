package com.jwtproject.userSecurity.Repository;

import com.jwtproject.userSecurity.Entity.Commandes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commandes,Long> {

    Commandes findByCommandeId(Long commandeId);

    boolean existsByNom(String nom);


    Page<Commandes> findAllByCommandeStatusOrderByCreateTimeDes(Integer orderStatus , Pageable pageable);

    Page<Commandes> findAllByCustomerUsernameByOrderStatusAscCreateTimeDesc(String customerUsername, Pageable pageable);

    Page<Commandes> findAllByCommandeByOrderStatusAscCreateTimeDesc(Pageable pageable);

    Page<Commandes> findAllByCustomerPhoneOrderByOrderStatusAsCreateTimeDesc(String customerphone,Pageable pageable);
}
