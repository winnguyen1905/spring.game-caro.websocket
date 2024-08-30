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
public class Record extends Base {
    private UUID id;
    private GamePlay result;
    private User winner;

    public Record() {
        super();
        this.id = UUID.randomUUID();
    }
}