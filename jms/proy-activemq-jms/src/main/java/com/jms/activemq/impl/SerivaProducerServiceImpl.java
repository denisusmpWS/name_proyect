package com.jms.activemq.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.jms.activemq.model.Person;
import com.jms.activemq.service.SerivaProducerService;

/*ENCARGADA DE ENVIAR EL OBJETO MESSAGE A LA COLA O DESTINO A TRAVES jmsTemplate*/

@Service
public class SerivaProducerServiceImpl implements SerivaProducerService {

	
	private static final String SIMPLE_QUEUE_IN="jms.queue";
	
	/*AL SER DECLARADO FINAL REQUIERE DE ESTAR EN UN CONSTRUCTOR INMEDIATAMENTE E INICIALIZADO*/
	private final JmsTemplate jmsTemplate;
	
	/*constructor*/
	@Autowired /*PARA OBTENER EL VALOR SINO SERA NULL YA QUE SPRING POR DEFECTO IMPLEMENTA ESTA CLASE*/
	public SerivaProducerServiceImpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Override /*CONVIERTE A UN MESSAGE Y LO ENVIA A UNA COLA*/
	public void addPerson(Person person) {
		jmsTemplate.convertAndSend(SIMPLE_QUEUE_IN,person);
	}

}
