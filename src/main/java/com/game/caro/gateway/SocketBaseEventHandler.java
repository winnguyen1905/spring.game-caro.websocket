package com.game.caro.gateway; 

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.game.caro.entity.User;
import com.game.caro.service.UserService;

@Service
public class SocketBaseEventHandler {

    private final SocketIOServer server;

    public SocketBaseEventHandler(SocketIOServer server) {
        this.server = server;
        server.addConnectListener(onConnect);
        server.addDisconnectListener(onDisConnect);
    }

    public ConnectListener onConnect = new ConnectListener() {
        @Override
        public void onConnect(SocketIOClient client) {
            System.out.println(">> onconnected " + client.getSessionId());

            User user = new User("Unknown");
            user.setId(client.getSessionId());

            UserService.users.put(user.getId(), user);
            
            server.getBroadcastOperations().sendEvent("connected", client.getSessionId() + " connected");
        }
    };

    public DisconnectListener onDisConnect = new DisconnectListener() {
        @Override
        public void onDisconnect(SocketIOClient client) {
            System.out.println(">> disconnected " + client.getSessionId());
            UserService.users.remove(client.getSessionId());
            server.getBroadcastOperations().sendEvent("disconnected", client.getSessionId() + " disconnected");
        }
    };

}