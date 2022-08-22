package com.jwtproject.userSecurity.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.engine.internal.Cascade;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@ComponentScan
@Table(name="resesrvations")
@Data


public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private Timestamp date;

    @NotNull
    @ColumnDefault("0")
    private Integer reservationStatus;
    @ManyToOne
    private Restaurant restaurant;

    @OneToOne
    private User user;


    public Reservation(long id, Timestamp date, Restaurant restaurant, User user) {
        this.id = id;
        this.date = date;
        this.restaurant = restaurant;
        this.user = user;
    }

    public Reservation() {

    }
}
