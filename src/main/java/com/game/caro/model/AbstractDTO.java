package com.game.caro.model;

import com.game.caro.common.MessageType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AbstractDTO<T> {
    private T payload;
    private MessageType type;
}