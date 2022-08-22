package com.jwtproject.userSecurity.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "payement")
public class Payement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(length = 50)
    private String nom;

    @NotNull
    private int nombre;

    @NotNull
    private int montant;

    @NotNull
    private long pin;


    @ManyToOne
    @NotNull
    private User user;


}
