package com.game.caro.service;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIOClient;
import com.game.caro.model.MessageDTO;

@Service
public class MessageService {
    public void handleMessage(SocketIOClient socketIOClient, MessageDTO message) {}

}