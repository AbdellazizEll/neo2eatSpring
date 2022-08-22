package com.jwtproject.userSecurity.Service.Impl;



import com.jwtproject.userSecurity.Entity.Commandes;
import com.jwtproject.userSecurity.Repository.CommandeRepository;
import com.jwtproject.userSecurity.Response.MessageResponse;
import com.jwtproject.userSecurity.Service.CommandeSer;
import com.jwtproject.userSecurity.enums.CommandStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommandeService implements CommandeSer {

    @Autowired
    CommandeRepository commandeRepository;


    public Page<Commandes> findAll(Pageable pageable) {
        return commandeRepository.findAll(pageable);
    }

    @Override
    public Page<Commandes> findByStatus(Integer status, Pageable pageable) {
        return commandeRepository.findAllByCommandeStatusOrderByCreateTimeDes(status, pageable);
    }

    @Override
    public Page<Commandes> findByCustomerUsername(String username, Pageable pageable) {
        return commandeRepository.findAllByCustomerUsernameByOrderStatusAscCreateTimeDesc(username, pageable);
    }

    @Override
    public Page<Commandes> findByCustomerPhone(String phone, Pageable pageable) {
        return commandeRepository.findAllByCustomerPhoneOrderByOrderStatusAsCreateTimeDesc(phone, pageable);
    }

    @Override
    public Commandes findOne(Long CommandesId) {
        Commandes CommandesMain = commandeRepository.findByCommandeId(CommandesId);
        if(CommandesMain == null) {
            throw new CommandeNotFoundException("Commande not found");
        }
        return CommandesMain;
    }

    @Override
    @Transactional
    public Commandes finish(Long CommandesId) {
        Commandes CommandesMain = findOne(CommandesId);
        if(!CommandesMain.getCommandeStatus().equals(CommandStatusEnum.NEW.getCode())) {
            throw new CommandeNotFoundException("Commande Finished");
        }

        CommandesMain.setCommandeStatus(CommandStatusEnum.FINISHED.getCode());
        commandeRepository.save(CommandesMain);
        return commandeRepository.findByCommandeId(CommandesId);
    }

    @Override
    public Commandes cancel(Long commandesId) {
    Commandes commandeMain = findOne(commandesId);

    if(!commandeMain.getCommandeStatus().equals(CommandStatusEnum.NEW.getCode()))
    {
        throw new CommandeNotFoundException("Status not correct!");
    }
    commandeMain.setCommandeStatus(CommandStatusEnum.CANCELED.getCode());
    commandeRepository.save(commandeMain);

    return commandeRepository.findByCommandeId(commandesId);
    }

    public MessageResponse save(Commandes commandes) {
        boolean existe = commandeRepository.existsById(commandes.getId());
        if (existe){
            return new MessageResponse(true,"Echec Cette commande existe déja !","!");
        }
        commandeRepository.save(commandes);
        return new MessageResponse(true,
                "Succès Opération réalisée avec succès.","!");
    }


    @Transactional
    @Override
    public MessageResponse update(Commandes commandes) {
        boolean existe = commandeRepository.existsById(commandes.getId());
        if (!existe){
            boolean existe1 = commandeRepository.existsByNom(commandes.getCustomerUsername());
            return new MessageResponse(true,"Echec Cette equipe existe déja !","!");
        }
        commandeRepository.save(commandes);
        return new MessageResponse(true,"Succès Opération réalisée avec succès.","!");
    }

    @Override
    public MessageResponse delete(Long id) {

        Commandes commande = findById(id);


        if(commande == null){
            return new MessageResponse(true,"Cet enregistrement n'existe pas ","!");

        }

        commandeRepository.delete(commande);

        return new MessageResponse(true,"Succés , l'enregistrement a été supprimé avec succés .","!");


    }

    @Override
    public void deleteCommandes(Long id) {
       commandeRepository.deleteById(id);
    }


    public Commandes findById(Long id) {
        Commandes commandes = commandeRepository.findById(id).orElse(null);
        return commandes;
    }



}
 class CommandeNotFoundException extends RuntimeException {
    public CommandeNotFoundException(String message) {
        super(message);
    }
}