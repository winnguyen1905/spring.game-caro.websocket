package com.game.caro.socket;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.game.caro.model.MessageDTO;

@Component
public class SocketServer {

    private final SocketIOServer server;
    private final SocketFactory socketFactory;

    public SocketServer(SocketIOServer server, SocketFactory socketFactory) {
        this.server = server;
        this.socketFactory = socketFactory;
        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
        server.addEventListener("send_message", MessageDTO.class, onMessageReceived());
    }

    private DataListener<MessageDTO> onMessageReceived() {
        return (socketIOClient, message, ackRequest) -> {
            // Logger.info("message: " + message);
            this.socketFactory.handleMessage(socketIOClient, message);
        };
    }

    private ConnectListener onConnected() {
        return socketIOClient -> {
            Map<String, List<String>> urlParams = socketIOClient.getHandshakeData().getUrlParams();

            String room = String.join("", urlParams.get("room"));
            String username = String.join("", urlParams.get("username"));

            socketIOClient.joinRoom(room);

            // socketFactory.saveInfoMessage(socketIOClient, "welcome " + username, room);

            // log.info("connected: {} {} {}", socketIOClient.getSessionId(), room, username);
        };
    }

    private DisconnectListener onDisconnected() {
        return socketIOClient -> {
            Map<String, List<String>> urlParams = socketIOClient.getHandshakeData().getUrlParams();

            String room = String.join("", urlParams.get("room"));
            String username = String.join("", urlParams.get("username"));
            // socketFactory.saveInfoMessage(socketIOClient, "see you later " + username, room);

            // log.info("disconnected: {} {} {}", socketIOClient.getSessionId(), room, username);
        };
    }
}