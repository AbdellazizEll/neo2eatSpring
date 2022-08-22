package com.jwtproject.userSecurity.Repository;

import com.jwtproject.userSecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    boolean existsByUsername(String username);


}
