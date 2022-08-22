package com.jwtproject.userSecurity.Entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="commandes")
@Data
public class Commandes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
        private User user;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "commande")
    private Set<Plat> plats = new HashSet<>();

    @ManyToOne
    private Restaurant restaurant;


    @NotEmpty
    private String customerEmail ;

    @NotEmpty
    private String customerPhone;


    @NotEmpty
    private String customerUsername;

    @NotEmpty
    private String customerAdresse;

    @NotEmpty
    private BigDecimal total;

    @NotNull
    @ColumnDefault("0")
    private Integer commandeStatus;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    public Commandes (long id, User user, Set<Plat> plats, Restaurant restaurant, String customerEmail, String customerPhone, String customerUsername, String customerAdresse, BigDecimal total, Integer commandeStatus, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.user = user;
        this.plats = plats;
        this.restaurant = restaurant;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerUsername = customerUsername;
        this.customerAdresse = customerAdresse;
        this.total = total;
        this.commandeStatus = commandeStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Commandes() {

    }
}
