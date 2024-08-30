package com.game.caro.entity;

import java.time.Instant;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Base {
    private UUID id;
    private UUID sessionId;
    private Instant createdDate;

    public Base() {
        // this.id = UUID.randomUUID();
        this.createdDate = Instant.now();
    }
}