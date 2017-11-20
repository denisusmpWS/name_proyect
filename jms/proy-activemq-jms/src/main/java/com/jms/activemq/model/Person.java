package com.jms.activemq.model;

import java.io.Serializable;


public class Person implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5509516652251695027L;
	private final String id;
	private final String name;
	private final String year;
	private final String status;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getYear() {
		return year;
	}
	public String getStatus() {
		return status;
	}
	public Person(String id, String name, String year, String status) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.status = status;
	}
	


	
	
}
