package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Food {

    private UUID id;
    private int taste;
    private String kindFood;
    private Date birthday;

    public Food(int taste, String kindFood) {
        this.taste = taste;
        this.kindFood = kindFood;
        this.birthday = new Date();
        this.id = UUID.randomUUID();
    }

}
