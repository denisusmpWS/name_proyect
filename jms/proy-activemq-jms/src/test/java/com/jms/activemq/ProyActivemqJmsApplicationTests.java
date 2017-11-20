package com.jms.activemq;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.jms.activemq.model.Person;
import com.jms.activemq.service.SerivaProducerService;
import com.jms.activemq.service.SerivaReceiveService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ProyActivemqJmsApplication.class)
public class ProyActivemqJmsApplicationTests {

	/*PRODUCER*/
	@Autowired
	private SerivaProducerService serivaProducerService;
	/*RECEIVER*/
	@Autowired
	private SerivaReceiveService serivaReceiveService;
	
	
	
	@Test
	public void sendSimpleMessage(){
		//SE AÑADE A UNA PERSONA
		Person person=new Person("A001", "DENIS", "27", "0");
		
		serivaProducerService.addPerson(person);
		//LISTENER: RECIBISTES A LA PERSONA?
		Optional<Person> receivePerson=
				serivaReceiveService.getReceivePerson("A001");
		assertTrue(receivePerson.isPresent());
		assertEquals("A001", receivePerson.get().getId());
	
	
	}

}
