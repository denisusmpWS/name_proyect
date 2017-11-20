package com.jms.activemq.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jms.activemq.model.Person;
import com.jms.activemq.service.SerivaReceiveService;

@Service
public class SerivaReceiveServiceImpl implements SerivaReceiveService {

	private final List<Person> receiverPersons=new ArrayList<Person>();
	
	@Override
	public void registerPerson(Person person) {
		this.receiverPersons.add(person);
		
	}

	@Override
	public Optional<Person> getReceivePerson(String id) {
		return receiverPersons.stream().
				filter(o -> o.getId().equals(id)).findFirst();
	}

	
	
	
}
