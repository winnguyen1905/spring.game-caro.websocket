package com.game.caro.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.game.caro.entity.User;

@Service
public class UserService {
    public static Map<UUID, User> users = new HashMap<>();
    public static Map<UUID, UUID> sessionIds = new HashMap<>();
    
    public static void addUser(User user, UUID sessionId) {
        users.put(sessionId, user);
        sessionIds.put(sessionId, user.getId());
    }

    public static User getUserBySessionId(UUID sessionId) {
        return users.get(sessionId);
    }
}