package com.example.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;


@Data
@AllArgsConstructor
public class Deity {

    private UUID id;
    private String name;
    private Date age;

    public Deity(String name, Date age) {
        this.name = name;
        this.age = age;
        this.id = UUID.randomUUID();
    }
}
