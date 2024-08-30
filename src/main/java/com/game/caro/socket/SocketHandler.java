package com.game.caro.socket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SocketHandler {

    private final SocketIOServer server;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        System.out.println("Client connected: " + client.getSessionId());
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        System.out.println("Client disconnected: " + client.getSessionId());
    }

    // private final RoomService roomService;
    // private final UserService userService;
    // private final GamePlayService gamePlayService;

    // public void handleMessage(SocketIOClient socketIOClient, MessageDTO<?> message) {
    //     if(message.getType().equals(MessageType.USER)) this.userService.handleMessage(socketIOClient, message);
    //     else if(message.getType().equals(MessageType.GAMEPLAY)) this.gamePlayService.handleMessage(socketIOClient, message);
    //     else if(message.getType().equals(MessageType.ROOM)) this.roomService.handleMessage(socketIOClient, message);
    // }

}