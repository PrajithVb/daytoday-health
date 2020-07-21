package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.output.PersonOutput;
import com.example.demo.util.Paths;

@RestController
@RequestMapping(Paths.PERSON)
public class PersonController {
	
	
	
	public ResponseEntity<PersonOutput> createPerson(){
		return ResponseEntity.ok(new PersonOutput());
	}
	public ResponseEntity<List<PersonOutput>> getPersonByOrg(){
		return ResponseEntity.ok(new ArrayList<PersonOutput>());
	}
	public ResponseEntity<PersonOutput> updatePerson(){
		return ResponseEntity.ok(new PersonOutput());
	}
	public ResponseEntity<PersonOutput> getPersonStartingwithName(){
		return ResponseEntity.ok(new PersonOutput());
	}

}
