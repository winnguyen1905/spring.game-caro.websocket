package com.game.caro.gateway;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.game.caro.model.MessageDTO;

@Controller
public class MessageController {

    @SendTo("/topic/public")
    @MessageMapping("/chat.sendMessage")
    public MessageDTO sendMessage(MessageDTO MessageDTO) {
        return MessageDTO;
    }

    @SendTo("/topic/public")
    @MessageMapping("/chat.addUser")
    public MessageDTO addUser(MessageDTO MessageDTO, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", MessageDTO.getSender());
        return MessageDTO;
    }
}