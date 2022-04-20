package com.sip.ams.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.entities.Message;
import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.MessageRepository;


@Controller
@RequestMapping("/message/")

public class MessageController {
private final MessageRepository messagerepository;
	
    @Autowired
    public MessageController(MessageRepository messagerepository) {
        this.messagerepository = messagerepository;
    }
    
    
    @GetMapping("list")
    
    //@ResponseBody
    public String listMessages(Model model) {
    	
    	
    	List<Message> lp = (List<Message>)messagerepository.findAll();
    	if((lp.size())==0)
    		lp=null;
        model.addAttribute("messages",lp);
    	        model.addAttribute("messages", messagerepository.findAll());
    	        return "message/listMessages";
        
        //
        //System.out.println(lp);
        
        //return "Nombre de fournisseur = " + lp.size();
    }
    
    
    
    @GetMapping("add")
    public String showAddMessageForm(Model model) {
    	Message message = new Message();// object dont la valeur des attributs par defaut
    	model.addAttribute("message", message);
        return "message/addMessage";
    }
    
    @PostMapping("add")
    public String addMessage(@Valid Message message, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "message/addMessage";
        }
        messagerepository.save(message);
        return "redirect:list";
    }
}
