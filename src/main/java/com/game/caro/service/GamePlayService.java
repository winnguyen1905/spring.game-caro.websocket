package com.game.caro.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIOClient;
import com.game.caro.entity.GamePlay;
import com.game.caro.model.MessageDTO;

@Service
public class GamePlayService {
    public static Map<UUID, GamePlay> users = new HashMap<>();
    public void handleMessage(SocketIOClient socketIOClient, MessageDTO message) {}
}