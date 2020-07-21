package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modal.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
	public Person findByFirstName(String firstName);
	  public List<Person> findByLastName(String lastName);

}
