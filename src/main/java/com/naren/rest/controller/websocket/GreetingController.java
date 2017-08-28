package com.naren.rest.controller.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.naren.rest.model.websocket.Message;
import com.naren.rest.scheduler.ScheduledUpdatesOnTopic;

/**
 * 
 * @author ntanwa
 *
 */
@Controller
public class GreetingController {

	@Autowired
	ScheduledUpdatesOnTopic schedular;

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Message greeting(Message message) throws Exception {
		return message;
	}
}
