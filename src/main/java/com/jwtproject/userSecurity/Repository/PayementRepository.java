package com.jwtproject.userSecurity.Repository;

import com.jwtproject.userSecurity.Entity.Payement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayementRepository extends JpaRepository<Payement,Long> {

    boolean existsByNom(String nom);
}
