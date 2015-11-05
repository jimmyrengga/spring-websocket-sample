/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jimmyrengga.controller;

import io.github.jimmyrengga.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jimmy
 */
@Controller
@RequestMapping("/api/")
public class InfoController {
    
    @Autowired
    private MessageService messageService;
    
    @SendTo("/message/sendToUser/{user}/{content}")
    public void broadcastInfo(@PathVariable String user, 
            @PathVariable String content) {
        messageService.broadcastToUser(user, content);
    }
    
}
