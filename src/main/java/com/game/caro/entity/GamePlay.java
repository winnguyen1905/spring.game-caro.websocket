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
public class GamePlay {
    private UUID id;
    private Room room;
    private int[][] matrix;
}