package com.game.caro.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GamePlay extends Base {
    private Room room;
    private int[][] matrix;

    public GamePlay(Room room, int[][] matrix) {
        super();
        this.room = room;
        this.matrix = matrix;
    }
}