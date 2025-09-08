package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ChatController {
    // agar koi /app/sendMessage  par kuch bhejega to vo sidha /topic/messages par aa jayega.
    @MessageMapping("/sendMessage") // Maps webSocket messages to the destination.
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message){
            return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }

}
