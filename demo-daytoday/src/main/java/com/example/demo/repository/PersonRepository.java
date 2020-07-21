package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Person;
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	
	
	  public List<Person> findByDeptId(String deptId);
	  public List<Person> findAllBy(TextCriteria criteria);
	  public List<Person> findByFirstNameStartingWith(String name);

}
