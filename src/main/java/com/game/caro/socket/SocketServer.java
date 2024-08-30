package com.game.caro.socket;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.game.caro.model.MessageDTO;
import com.game.caro.model.MessageDTO;

@Service
public class SocketServer {

    private final SocketIOServer server;

    public SocketServer(SocketIOServer server) {
        this.server = server;
        server.addConnectListener(onUserConnectWithSocket);
        server.addDisconnectListener(onUserDisconnectWithSocket);
        server.addEventListener("send_message", MessageDTO.class, onSendMessage);
    }

    // Listen event `send_message`
    public DataListener<MessageDTO> onSendMessage = new DataListener<MessageDTO>() {
        @Override
        public void onData(SocketIOClient client, MessageDTO message, AckRequest acknowledge) throws Exception {

            // 3 param is : event name, send to ?, content
            server.getBroadcastOperations().sendEvent("event", client, message);

            // đã nhận được tin nhắn ? 
            acknowledge.sendAckData("Message send to target user successfully");
        }
    };

    // active when have new connect
    public ConnectListener onUserConnectWithSocket = new ConnectListener() {
        @Override
        public void onConnect(SocketIOClient client) {
            System.out.println("onconnected " + client.getSessionId());
        }
    };

    // active when have disconnect by any user
    public DisconnectListener onUserDisconnectWithSocket = new DisconnectListener() {
        @Override
        public void onDisconnect(SocketIOClient client) {
            System.out.println("disconnected " + client.getSessionId());
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