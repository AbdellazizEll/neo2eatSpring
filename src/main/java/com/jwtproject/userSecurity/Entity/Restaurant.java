package com.jwtproject.userSecurity.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@ComponentScan
@Table(name="Restaurants")

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(name="rest_name")
    private String restname;
    @Column(name="adresse")
    private String adresse;
    @Column(name="lattitude")
    private String lattitude;
    @Column(name="longitude")
    private String longitude;
    @Column(name="Tel")
    private String phone;

    private String imagerestau;

    @OneToMany(mappedBy = "id")
    private  Set<Plat> menu = new HashSet<>();

    @OneToMany(mappedBy = "id")
    private  Set<Commandes> commands = new HashSet<>(); //discutable

    @OneToMany(mappedBy = "id")
    private Set<Reservation> reservations = new HashSet<>(); //discutable

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User gerant;

      // discutable


    public Restaurant(long id, String restname, String adresse, String lattitude, String longitude, String phone, String imagerestau, Set<Plat> menu, Set<Commandes> commands, Set<Reservation> reservations, User gerant) {
        this.id = id;
        this.restname = restname;
        this.adresse = adresse;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.phone = phone;
        this.imagerestau = imagerestau;
        this.menu = menu;
        this.commands = commands;
        this.reservations = reservations;
        this.gerant = gerant;
    }

    public Restaurant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRestname() {
        return restname;
    }

    public void setRestname(String restname) {
        this.restname = restname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Plat> getMenu() {
        return menu;
    }

    public void setMenu(Set<Plat> menu) {
        this.menu = menu;
    }

    public Set<Commandes> getCmds() {
        return commands;
    }

    public void setCmds(Set<Commandes> cmds) {
        commands = commands;
    }

    public Set<Reservation> getResv() {
        return reservations;
    }

    public void setResv(Set<Reservation> resv) {
        this.reservations = resv;
    }

    public User getGerant() {
        return gerant;
    }

    public void setGerant(User gerant) {
        this.gerant = gerant;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", restname='" + restname + '\'' +
                ", adresse='" + adresse + '\'' +
                ", lattitude='" + lattitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", phone='" + phone + '\'' +
                ", imagerestau='" + imagerestau + '\'' +
                ", menu=" + menu +
                ", commands=" + commands +
                ", reservations=" + reservations +
                ", gerant=" + gerant +
                '}';
    }
}
