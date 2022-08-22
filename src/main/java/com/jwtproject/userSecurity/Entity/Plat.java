package com.jwtproject.userSecurity.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="plats")
@Data
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String nomplat;

    @NotNull
    private String description;

    @NotNull
    private Integer platStatus;




    @OneToOne
    private Category category;

    @OneToOne
    private Restaurant restaurant;


    @ManyToOne
    private Commandes commande;




    public Plat(long id, String nomplat, String description, Category category, Restaurant restaurant) {
        this.id = id;
        this.nomplat = nomplat;
        this.description = description;
        this.category = category;
        this.restaurant = restaurant;
    }

    public Plat(String nomplat, String description, Category category, Restaurant restaurant) {
        this.nomplat = nomplat;
        this.description = description;
        this.category = category;
        this.restaurant = restaurant;
    }

    public Plat() {

    }
}
