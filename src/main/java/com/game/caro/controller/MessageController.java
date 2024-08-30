package com.game.caro.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.game.caro.model.MessageDTO;
import com.game.caro.service.MessageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @SendTo("/topic/public")
    @MessageMapping("/chat.sendMessage")
    public MessageDTO sendMessage(MessageDTO MessageDTO) {
        return MessageDTO;
    }

    @SendTo("/topic/public")
    @MessageMapping("/chat/sendMessage/{convId}")
    public MessageDTO sendMessageToConvId(@Payload MessageDTO message,
        SimpMessageHeaderAccessor headerAccessor,
        @DestinationVariable("convId") String conversationId) {
        // this.messageService.sendMessageToConvId(message, conversationId, headerAccessor);
        return message;
    }
}