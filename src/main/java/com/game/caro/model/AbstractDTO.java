package com.game.caro.model;

import java.util.UUID;

import com.game.caro.common.MessageType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AbstractDTO {
    private MessageType type;
    private UUID senderId;
}