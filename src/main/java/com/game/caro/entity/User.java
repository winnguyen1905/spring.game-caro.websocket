package com.game.caro.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class User {
    private UUID id;
    private String name;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}