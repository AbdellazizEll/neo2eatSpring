package com.jwtproject.userSecurity.Service;


import com.jwtproject.userSecurity.Entity.Payement;
import com.jwtproject.userSecurity.Response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface PayementSer{


    public MessageResponse save(Payement payement);
    public MessageResponse update(Payement payement);
    public MessageResponse delete(Long id);
    public List<Payement> findAll();
    public Payement findById(Long id);
}
