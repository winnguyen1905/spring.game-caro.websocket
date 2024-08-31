package com.game.caro.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageDTO extends AbstractDTO {
    private UUID senderId;
    private UUID recieverId;
    private String content;
}