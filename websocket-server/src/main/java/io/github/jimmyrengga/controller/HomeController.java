package io.github.jimmyrengga.controller;

import io.github.jimmyrengga.Message;
import io.github.jimmyrengga.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jimmy
 */
@Controller
public class HomeController {

    @Autowired MessageService messageService;
    
    @RequestMapping("/")
    public String index(Message message) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String broadcastMessage(@ModelAttribute("message") Message message,
            BindingResult result) {
        messageService.broadcastToUser(message);
        
        return "index";
    }
    
}
