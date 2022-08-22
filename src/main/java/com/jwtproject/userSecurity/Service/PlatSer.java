package com.jwtproject.userSecurity.Service;


import com.jwtproject.userSecurity.Entity.Category;
import com.jwtproject.userSecurity.Entity.Plat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatSer extends JpaRepository<Plat,Long> {


    Plat findOne(long platId);

    // All  products
    Page<Plat> findAll(Pageable pageable);

    Page<Plat> findUpAll(Pageable pageable);

    // All products in a category
    Page<Plat> findPlatByAllInCategory(Category category, Pageable pageable);

    Page<Plat> findPlatByStatus(Integer platstatus, Pageable pageable);




    Plat update(Plat platInfo);
    Plat save(Plat platInfo);

    void delete(long platId);
}
