package com.jwtproject.userSecurity.Service.Impl;



import com.jwtproject.userSecurity.Entity.Payement;
import com.jwtproject.userSecurity.Repository.PayementRepository;
import com.jwtproject.userSecurity.Response.MessageResponse;
import com.jwtproject.userSecurity.Service.PayementSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class PayementService implements PayementSer {


    @Autowired
    PayementRepository payementRepository;

    @Transactional
    @Override
    public MessageResponse save(Payement payement) {
        boolean existe = payementRepository.existsByNom(payement.getNom());
        if (existe){
            return new MessageResponse(false,"Echec ! Cette Payement existe déja !","Echec");
        }
        payementRepository.save(payement);
        return new MessageResponse(true,"Succès Opération réalisée avec succès.","!");
    }


    @Transactional
    @Override
    public MessageResponse update(Payement payement) {
        boolean existe = payementRepository.existsById(payement.getId());
        if (!existe){
            boolean existe1 = payementRepository.existsByNom(payement.getNom());
            return new MessageResponse(false,"Echec  Cette Payement existe déja !","!");
        }
        payementRepository.save(payement);
        return new MessageResponse(true,"Succès Opération réalisée avec succès.","!");
    }

    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Payement payement = findById(id);
        if (payement==null){
            return new MessageResponse(true,"Echec Cet enregistrement n'existe pas !" ,"!");
        }
        payementRepository.delete(payement);
        return new MessageResponse(true,"Succès l'enregistrement à été supprimé avec succès.","!");
    }

    @Override
    public List<Payement> findAll() {

        return payementRepository.findAll();
    }

    @Override
    public Payement findById(Long id) {
        Payement payement = payementRepository.findById(id).orElse(null);
        return payement;
    }
}
 class PayementNotFoundException extends RuntimeException {
    public PayementNotFoundException(String message) {
        super(message);
    }
}