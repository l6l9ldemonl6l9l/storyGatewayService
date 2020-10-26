package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;



import java.util.Date;

@Data
@AllArgsConstructor

public class Crow extends FairyAnimal {
    private int sizeMind;
    public Crow(String name, Date lastLunchTime, int energy, int sizeMind) {
        super(name, lastLunchTime, energy);
        this.sizeMind = sizeMind;
    }

}
