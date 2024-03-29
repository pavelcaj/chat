package com.example.chat.controller;

import com.example.chat.chat.ChatMessage;
import com.example.chat.chat.User;
import com.example.chat.rep.MessageRepository;
import com.example.chat.rep.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
@Controller
public class ChatController {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        ChatMessage message = new ChatMessage();
        message.setContent(chatMessage.getContent());
        message.setSender(chatMessage.getSender());
        messageRepository.save(message);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
            headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
            User user = new User();
            user.setLogin(chatMessage.getSender());
            userRepository.save(user);
            return chatMessage;
    }
}