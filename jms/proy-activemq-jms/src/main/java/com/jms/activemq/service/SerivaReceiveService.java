package com.jms.activemq.service;

import java.util.Optional;

import com.jms.activemq.model.Person;

public interface SerivaReceiveService {
	
	public void registerPerson(Person person);
	public Optional<Person> getReceivePerson(String id);

}
