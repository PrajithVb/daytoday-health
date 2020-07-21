package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.PersonDetails;
import com.example.demo.modal.ApiOutput;
import com.example.demo.modal.Person;
import com.example.demo.output.PersonOutput;
import com.example.demo.service.PersonApiService;
import com.example.demo.util.Paths;
import com.google.gson.JsonObject;

@RestController
@RequestMapping(Paths.PERSON)
public class PersonController {
	
	@Autowired
	PersonApiService personApiService;
	 
	@PostMapping(value = Paths.START)
	public ResponseEntity<Person> createPerson(@RequestBody PersonDetails json){
		if(Objects.isNull(json)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(personApiService.create(json));
	}
	@GetMapping(value = Paths.ORG_ID)
	public ResponseEntity<PersonOutput> getPersonByOrg(@PathVariable String orgId){
		if(StringUtils.isEmpty(orgId)) {
			return ResponseEntity.badRequest().body(new PersonOutput(false));
		}
		return ResponseEntity.ok(personApiService.findByOrg(orgId));
	}
	@PostMapping(value = Paths.UPDATE)
	public ResponseEntity<PersonOutput> updatePerson(@RequestBody PersonDetails json){
		if(Objects.isNull(json)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(personApiService.update(json));
	}
	@GetMapping(value = Paths.NAME)
	public ResponseEntity<PersonOutput> getPersonStartingwithName(@PathVariable String text){
		if(StringUtils.isEmpty(text)) {
			return ResponseEntity.badRequest().body(new PersonOutput(false));
		}
		return ResponseEntity.ok(personApiService.search(text));
	}

}
