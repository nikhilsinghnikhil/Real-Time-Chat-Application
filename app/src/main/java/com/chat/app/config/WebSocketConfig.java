package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //it tells spring this app use web socket for real time communication.
//Message broking - It is a way of routing messages.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // WebSocketMessageBrokerConfigurer - Defines methods for configuring message handling with messaging protocols like STOMP from WebSocket clients.
    // provide two way communication channel b/w a client and server.
    // STOMP - It sits on top of web socket which provide structural message.

    // we are generate this from the right click and generate override.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080") // This is a security feature means it goes only with this localhost.
                .withSockJS(); //This makes app accessible to more users.
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
       // set message broker
        // expect message with /app/sendmessage
        registry.enableSimpleBroker("/topic"); // it handle messages from topics.  /topic/chatRoom1
        registry.setApplicationDestinationPrefixes("/app");
    }
}
