package com.game.caro.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class User extends Base {
    private String name;

    public User(String name) {
        super();
        this.name = name;
    }
}