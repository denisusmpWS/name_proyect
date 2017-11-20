package com.jms.activemq.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import com.jms.activemq.listener.SimpleListener;

@Configuration
@EnableJms
public class JMSConfiguration {
	
	//COLA IN DESTINO
	public static final String QUEUE_IN_MODEL="jms.queue";
	
	/*METODO DE MAPEO DE CONECTION FACTORY*/
	
	@Bean
	public ConnectionFactory connectionFactory(){
		
		return new CachingConnectionFactory(
				//NOTA: colocar el nombre hostname de la maquina no localhost sino no se podra conectar al puerto listener
				new ActiveMQConnectionFactory("tcp://hp-HP:61616"));
	}

	/*
	public ActiveMQConnectionFactory connectionFactory2(){
		ActiveMQConnectionFactory connectionFactory=new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL("tcp://hp-HP:61616");
		connectionFactory.setUserName("admin");
		connectionFactory.setPassword("admin");
		return connectionFactory;
	}
	*/
	
	//LISTENER QUE RETORNA UN MESSAGE LISTENER ADAPTER DEFINE UN METODO EL CUAL VA RECIBIR EL MESSAGE RECIBIDO EN LA COLA
	@Bean
	public MessageListenerAdapter receiver(SimpleListener simpleListener){
		return new MessageListenerAdapter(simpleListener){{
			setDefaultListenerMethod("getReceivePerson");
		}};
	}
	
	//CONFIGURAR UN CONTAINER
	@Bean
	SimpleMessageListenerContainer container(final MessageListenerAdapter messagelistener,
									final ConnectionFactory connectionFactory){
		return new SimpleMessageListenerContainer(){{
			setMessageListener(messagelistener);
			setConnectionFactory(connectionFactory);
			setDestinationName(QUEUE_IN_MODEL);
		}};
	}
	
	

	@Bean
	JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
		return new JmsTemplate(connectionFactory);
	}
	

	
}
