package com.jms.activemq.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jms.activemq.model.Person;
import com.jms.activemq.service.SerivaReceiveService;

@Component
public class SimpleListener {

	@Autowired
	private SerivaReceiveService receiveService;
	
	
	public void getReceivePerson(Person person){		
		receiveService.registerPerson(person);
	}
	
}
