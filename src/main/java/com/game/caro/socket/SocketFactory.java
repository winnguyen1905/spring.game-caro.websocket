package com.game.caro.socket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIOClient;
import com.game.caro.common.MessageType;
import com.game.caro.entity.Base;
import com.game.caro.entity.User;
import com.game.caro.model.MessageDTO;
import com.game.caro.service.GamePlayService;
import com.game.caro.service.RoomService;
import com.game.caro.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SocketFactory {

    private final RoomService roomService;
    private final UserService userService;
    private final GamePlayService gamePlayService;

    public void handleMessage(SocketIOClient socketIOClient, MessageDTO<?> message) {
        if(message.getType().equals(MessageType.USER)) this.userService.handleMessage(socketIOClient, message);
        else if(message.getType().equals(MessageType.GAMEPLAY)) this.gamePlayService.handleMessage(socketIOClient, message);
        else if(message.getType().equals(MessageType.ROOM)) this.roomService.handleMessage(socketIOClient, message);
    }

}