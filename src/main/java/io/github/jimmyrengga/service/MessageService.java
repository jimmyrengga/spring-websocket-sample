package io.github.jimmyrengga.service;

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
    
    @Scheduled(fixedDelay = 5 * 1000L)
    public void broadcastNotification() {
        this.template.convertAndSend("/info", "Hi There, this notification is for all.");
    }
    
    public void broadcastToUser(String user, String content) {
        this.template.convertAndSendToUser(user, "/update", content);
    }
    
}
