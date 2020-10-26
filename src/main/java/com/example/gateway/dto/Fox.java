package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor

public class Fox extends FairyAnimal {

    private int sizeCunning;

    public Fox(String name, Date lastLunchTime, int energy, int sizeCunning) {
        super(name, lastLunchTime, energy);
        this.sizeCunning = sizeCunning;
    }

}
