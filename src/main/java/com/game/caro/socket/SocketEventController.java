package com.game.caro.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.corundumstudio.socketio.SocketIOServer;
import com.game.caro.model.MessageDTO;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
public class SocketEventController {

    @Autowired
    private SocketIOServer server;
    @Autowired
    private SocketBaseEventHandler baseEventHandler;
    @Autowired
    private SocketCoreEventHandler coreEventHandler;

    public SocketEventController() {
        server.addConnectListener(this.baseEventHandler.onUserConnectWithSocket);
        server.addDisconnectListener(this.baseEventHandler.onUserDisconnectWithSocket);
        // server.addEventListener(null);
    }

}