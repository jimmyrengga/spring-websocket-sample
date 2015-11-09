package io.github.jimmyrengga.controller;

import io.github.jimmyrengga.Message;
import io.github.jimmyrengga.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jimmy
 */
@Controller
@RequestMapping("/api/message")
public class HomeController {

    @Autowired MessageService messageService;

    @RequestMapping(method = RequestMethod.POST)
    public void sendToUser(@RequestBody Message message) {
        if(message == null) {
            throw new RuntimeException("Message must not be null");
        }
        
        messageService.broadcastToUser(message);
    }
}
