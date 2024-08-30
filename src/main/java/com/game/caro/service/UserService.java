package com.game.caro.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.SocketIOClient;
import com.game.caro.entity.User;
import com.game.caro.model.MessageDTO;

@Service
public class UserService {
    public static final Map<UUID, User> users = new HashMap<>();;
    public static final Map<String, Function<SocketIOClient, MessageDTO<User>>> actions = new HashMap<>();
}