/**
 * 
 */
package com.naren.rest.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.naren.rest.model.websocket.Greeting;

/**
 * @author ntanwa
 *
 */
@Component
@EnableScheduling	
public class ScheduledUpdatesOnTopic {

	@Autowired
	private SimpMessagingTemplate template;

	//@Scheduled(fixedDelay = 300)
	public void publishUpdates() {
		template.convertAndSend("/topic/greetings", new Greeting("Hello, Naredner!"));
	}

}
