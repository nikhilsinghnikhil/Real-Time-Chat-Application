package com.chat.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// It is going to represent a particular Message.
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ChatMessage {
        private Long id;
        private String sender;
        private String Content;
}
