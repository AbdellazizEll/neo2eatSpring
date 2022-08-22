package com.jwtproject.userSecurity.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@javax.persistence.Table(name="tables")
public class Table {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private long numtable;

    @NotNull
    private Boolean status;



    @ManyToOne
    @NotNull

    private Restaurant restaurant;
    @OneToOne
    private Reservation reservation;

    public Table(long id, long numtable, Boolean status, Restaurant restaurant, Reservation reservation) {
        this.id = id;
        this.numtable = numtable;
        this.status = status;
        this.restaurant = restaurant;
        this.reservation = reservation;
    }

    public Table(long numtable, Boolean status, Restaurant restaurant, Reservation reservation) {
        this.numtable = numtable;
        this.status = status;
        this.restaurant = restaurant;
        this.reservation = reservation;
    }

    public Table() {

    }
}
