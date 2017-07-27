package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

	@Autowired
	   private SimpMessagingTemplate messagingTemplate;

	  @MessageMapping("/chat/{username}")
	  public String greeting(@DestinationVariable String username, HelloMessage message) throws Exception {
	      messagingTemplate.convertAndSend("/topic/"+username,message);
	      System.out.println(message.getName());
	      return ""+message.getName() ;
	  }
}
	