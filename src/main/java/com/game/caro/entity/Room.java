package com.game.caro.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Room extends Base {
    private User owner;
    private User guest;
    private List<User> blacklist;

    public Room() {
        super();
        this.blacklist = new ArrayList<>();
    }
}