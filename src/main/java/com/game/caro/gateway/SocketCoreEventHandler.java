package com.game.caro.gateway;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.game.caro.entity.Room;
import com.game.caro.entity.User;
import com.game.caro.model.AbstractDTO;
import com.game.caro.model.MessageDTO;
import com.game.caro.service.RoomService;
import com.game.caro.service.UserService;

@Service
public class SocketCoreEventHandler {

    private final SocketIOServer server;

    public SocketCoreEventHandler(SocketIOServer server) {
        this.server = server;
        this.server.addEventListener("create_room", MessageDTO.class, onCreateRoom);
        this.server.addEventListener("join_room", MessageDTO.class, onJoinRoom);
        this.server.addEventListener("receive_message", MessageDTO.class, onChat);
        // this.server.addEventListener("send_message", MessageDTO.class, onChat);
    }

    public DataListener<MessageDTO> onCreateRoom = new DataListener<MessageDTO>() {
        @Override
        public void onData(SocketIOClient client, MessageDTO message, AckRequest acknowledge) throws Exception {
            User user = UserService.users.get(client.getSessionId());

            // 1. Create new room
            Room newRoom = new Room(user, null, new ArrayList<>());

            // 2. Add new Room in RoomService
            RoomService.rooms.put(newRoom.getId(), newRoom);
            RoomService.UserIdMapRoomId.put(user.getId(), newRoom.getId());

            // 3. Construct response message and send response message
            MessageDTO<Room> messageDTO = new MessageDTO<>();
            messageDTO.setReceiverId(user.getId());
            messageDTO.setDescription("Create room successfully");
            messageDTO.setData(newRoom);
            client.sendEvent("create_room", messageDTO);

            System.out.println(">> Create room successfully by id " + user.getId());

            // 4. Mark is seen message
            acknowledge.sendAckData("Message send to target user successfully");
        }
    };

    public DataListener<MessageDTO> onJoinRoom = new DataListener<MessageDTO>() {
        @Override
        public void onData(SocketIOClient client, MessageDTO message, AckRequest acknowledge) throws Exception {
            server.getBroadcastOperations().sendEvent("event", client, "cc t nhan duoc roi");
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