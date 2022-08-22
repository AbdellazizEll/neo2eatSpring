 package com.jwtproject.userSecurity.Entity;


import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
    @Table(name = "category")
    @Data
    @Getter
    public class Category
    {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        private String nomCat;
        private String descCat;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "plat_id", referencedColumnName = "id")
        private Plat plat;


        public Category(Long id, String nomCat, String descCat, Plat plat) {
            this.id = id;
            this.nomCat = nomCat;
            this.descCat = descCat;
            this.plat = plat;
        }

        public Category() {

        }
    }

