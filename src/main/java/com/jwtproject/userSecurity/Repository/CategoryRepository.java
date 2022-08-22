package com.jwtproject.userSecurity.Repository;

import com.jwtproject.userSecurity.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Repository
@CrossOrigin("*")
public interface CategoryRepository extends JpaRepository<Category,Long> {
    void deleteCategoryById(Long id);

    Optional<Category> findCategoryById(Long id);
}
