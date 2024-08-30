package com.game.caro.socket; 

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
        server.addConnectListener(onUserConnectWithSocket);
        server.addDisconnectListener(onUserDisconnectWithSocket);
    }

    // active when have new connect
    public ConnectListener onUserConnectWithSocket = new ConnectListener() {
        @Override
        public void onConnect(SocketIOClient client) {
            System.out.println(">> onconnected " + client.getSessionId());

            User user = new User("Unknown");
            user.setId(client.getSessionId());

            UserService.users.put(user.getId(), user);
            
            server.getBroadcastOperations().sendEvent("connected", client.getSessionId() + " connected");
        }
    };

    // active when have disconnect by any user
    public DisconnectListener onUserDisconnectWithSocket = new DisconnectListener() {
        @Override
        public void onDisconnect(SocketIOClient client) {
            System.out.println(">> disconnected " + client.getSessionId());
            UserService.users.remove(client.getSessionId());

            server.getBroadcastOperations().sendEvent("disconnected", client.getSessionId() + " disconnected");
        }
    };

    // private ConnectListener onConnected() {
    //     return socketIOClient -> {
    //         // Map<String, List<String>> urlParams = socketIOClient.getHandshakeData().getUrlParams();
    //         // String room = String.join("", urlParams.get("room"));
    //         // String username = String.join("", urlParams.get("username"));
    //         System.out.println(socketIOClient.getSessionId());
    //         // socketIOClient.joinRoom(room);

    //         // socketFactory.saveInfoMessage(socketIOClient, "welcome " + username, room);

    //         // log.info("connected: {} {} {}", socketIOClient.getSessionId(), room, username);
    //     };
    // }

    // private DisconnectListener onDisconnected() {
    //     return socketIOClient -> {
    //         Map<String, List<String>> urlParams = socketIOClient.getHandshakeData().getUrlParams();

    //         String room = String.join("", urlParams.get("room"));
    //         String username = String.join("", urlParams.get("username"));
    //         // socketFactory.saveInfoMessage(socketIOClient, "see you later " + username, room);

    //         // log.info("disconnected: {} {} {}", socketIOClient.getSessionId(), room, username);
    //     };
    // }
}