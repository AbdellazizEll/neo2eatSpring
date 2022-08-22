package com.jwtproject.userSecurity.Service;


import com.jwtproject.userSecurity.Entity.Commandes;
import com.jwtproject.userSecurity.Response.MessageResponse;
import org.aspectj.bridge.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommandeSer {

    Page<Commandes> findAll(Pageable pageable);

    Page<Commandes> findByStatus(Integer status, Pageable pageable);

    Page<Commandes> findByCustomerUsername(String email, Pageable pageable);

    Page<Commandes> findByCustomerPhone(String phone, Pageable pageable);

    Commandes findOne(Long commandesId);

    Commandes finish(Long commandesId);

    Commandes cancel(Long commandesId);

    public MessageResponse save(Commandes commandes);
    public MessageResponse update(Commandes commandes);
    public MessageResponse delete(Long id);

    @Transactional
    void deleteCommandes(Long id);


}

