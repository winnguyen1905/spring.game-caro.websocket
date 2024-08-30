package com.game.caro.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Room {
    private UUID id;
    private User lead;
    private User guest;
    private List<User> blacklist;

    public Room() {
        this.id = UUID.randomUUID();
        this.blacklist = new ArrayList<>();
    }
}