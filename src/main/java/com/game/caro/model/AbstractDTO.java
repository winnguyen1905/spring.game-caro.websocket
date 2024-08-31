package com.game.caro.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AbstractDTO implements Serializable {
    private String action;
}