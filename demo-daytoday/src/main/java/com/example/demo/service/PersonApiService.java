package com.example.demo.service;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.example.demo.bean.PersonDetails;
import com.example.demo.modal.Person;
import com.example.demo.output.PersonOutput;
import com.google.gson.JsonObject;

public interface PersonApiService {

	public Person create(PersonDetails json );
	public PersonOutput update(PersonDetails json );
	public PersonOutput search(String namePart );
	public PersonOutput findByOrg( String id );
	
}
