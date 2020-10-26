package com.example.gateway.dto;

import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;


@MappedSuperclass
public class FairyAnimal {

    private UUID id;
    private String name;
    private Date lastLunchTime;
    private int energy;

    public FairyAnimal() {
    }

    public FairyAnimal(String name, Date lastLunchTime, int energy) {
        this.name = name;
        this.lastLunchTime = lastLunchTime;
        this.energy = energy;
        this.id = UUID.randomUUID();
    }


}
