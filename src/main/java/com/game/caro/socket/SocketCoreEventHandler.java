package com.game.caro.socket;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.game.caro.model.MessageDTO;

@Service
public class SocketCoreEventHandler {

    private final SocketIOServer server;

    public SocketCoreEventHandler(SocketIOServer server) {
        this.server = server;
        this.server.addEventListener("create_room", MessageDTO.class, onCreateRoom);
    }

    public DataListener<MessageDTO> onCreateRoom = new DataListener<MessageDTO>() {
        @Override
        public void onData(SocketIOClient client, MessageDTO message, AckRequest acknowledge) throws Exception {

            // 3 param is : event name, send to ?, content
            server.getBroadcastOperations().sendEvent("event", client, "cc t nhan duoc roi");

            // đã nhận được tin nhắn ? 
            acknowledge.sendAckData("Message send to target user successfully");
        }
    };

    public DataListener<MessageDTO> onJoinRoom = new DataListener<MessageDTO>() {
        @Override
        public void onData(SocketIOClient client, MessageDTO message, AckRequest acknowledge) throws Exception {

            // 3 param is : event name, send to ?, content
            server.getBroadcastOperations().sendEvent("event", client, "cc t nhan duoc roi");

            // đã nhận được tin nhắn ? 
            acknowledge.sendAckData("Message send to target user successfully");
        }
    };

    public DataListener<MessageDTO> onChat = new DataListener<MessageDTO>() {
        @Override
        public void onData(SocketIOClient client, MessageDTO message, AckRequest acknowledge) throws Exception {

            // 3 param is : event name, send to ?, content
            server.getBroadcastOperations().sendEvent("event", client, "cc t nhan duoc roi");

            // đã nhận được tin nhắn ? 
            acknowledge.sendAckData("Message send to target user successfully");
        }
    };

    public DataListener<MessageDTO> onStartGamePlay = new DataListener<MessageDTO>() {
        @Override
        public void onData(SocketIOClient client, MessageDTO message, AckRequest acknowledge) throws Exception {

            // 3 param is : event name, send to ?, content
            server.getBroadcastOperations().sendEvent("event", client, "cc t nhan duoc roi");

            // đã nhận được tin nhắn ? 
            acknowledge.sendAckData("Message send to target user successfully");
        }
    };

}