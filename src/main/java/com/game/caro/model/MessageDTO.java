package com.game.caro.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageDTO<T> implements Serializable {
    private UUID senderId;
    private UUID receiverId;
    private String description;
    private T data;

    public void setData(Object data) {
        this.data = (T) data;
    }
}