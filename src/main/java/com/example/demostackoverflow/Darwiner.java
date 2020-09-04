package com.example.demostackoverflow;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Darwiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String darwinerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDarwinerName() {
        return darwinerName;
    }

    public void setDarwinerName(String darwinerName) {
        this.darwinerName = darwinerName;
    }
}
