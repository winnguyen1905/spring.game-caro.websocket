package com.game.caro.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Base implements Serializable {
    private UUID id;
    private String createdDate;

    public Base() {
        this.createdDate = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
    }
}