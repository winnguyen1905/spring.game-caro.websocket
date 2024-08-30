package com.game.caro.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageDTO<T> extends AbstractDTO {
    private T payload;
}