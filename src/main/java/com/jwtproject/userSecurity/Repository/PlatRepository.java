package com.jwtproject.userSecurity.Repository;


import com.jwtproject.userSecurity.Entity.Category;
import com.jwtproject.userSecurity.Entity.Plat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
public interface PlatRepository extends JpaRepository<Plat,Long> {

    public Page<Plat> findAll(Pageable pageable);
    Plat findByPlatId(Long id);
    // on sale recompense
    Page<Plat> findAllByPlatStatusOrderByProductIdAsc(Integer platStatus, Pageable pageable);

    // product in one category
    Page<Plat> findAllByCategoryTypeOrderByProductIdAsc(Category category , Pageable pageable);






    Page<Plat> findAllByOrderByPlatId(Pageable pageable);


}
