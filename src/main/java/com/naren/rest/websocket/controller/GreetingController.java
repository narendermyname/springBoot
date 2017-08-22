package com.naren.rest.websocket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.naren.rest.scheduler.ScheduledUpdatesOnTopic;
import com.naren.rest.websocket.model.Greeting;
import com.naren.rest.websocket.model.HelloMessage;

@Controller
public class GreetingController {

	@Autowired
	ScheduledUpdatesOnTopic schedular;
	
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        //schedular.publishUpdates();
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
