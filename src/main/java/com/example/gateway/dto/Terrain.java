package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Terrain {
    private UUID id;
    private String name;
    private int sizeBeauty;


    public Terrain(String name, int sizeBeauty) {
        this.name = name;
        this.sizeBeauty = sizeBeauty;
        this.id = UUID.randomUUID();
    }


}
