package io.github.jimmyrengga.service;

import io.github.jimmyrengga.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 *
 * @author jimmy
 */
@Service
@EnableScheduling
@EnableWebSocketMessageBroker
public class MessageService {
    
    @Autowired 
    SimpMessagingTemplate template;
    
    @Scheduled(fixedDelay = 10 * 1000L)
    public void broadcastNotification() {
        this.template.convertAndSend("/info", "Hi There, this notification is for all.");
    }
    
    public void broadcastToUser(Message message) {
        this.template.convertAndSendToUser(message.getUsername(), "/update", message.getContent());
    }
    
}
