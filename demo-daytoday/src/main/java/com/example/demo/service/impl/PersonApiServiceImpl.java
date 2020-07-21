package com.example.demo.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Name;
import com.example.demo.bean.PersonDetails;
import com.example.demo.modal.Address;
import com.example.demo.modal.HumanName;
import com.example.demo.modal.Organization;
import com.example.demo.modal.Person;
import com.example.demo.output.PersonOutput;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonApiService;
import com.example.demo.util.Gender;
import com.example.demo.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("personApiService")
public class PersonApiServiceImpl implements PersonApiService {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public Person create(PersonDetails json) {
		Person p = new Person();
		try {
		if(Objects.nonNull(json)) {
		p.setId("PERSON_"+Calendar.getInstance().getTimeInMillis());
		log.info("in");
		if(json.getName()!= null) {
			log.info("in1");
			if(json.getName().size()>0) {
				
				 List<Name> name = json.getName();
				 name.forEach( hum ->{
					 
					 HumanName add = JsonUtil.getJackson2DeserializedObject(JsonUtil.deepSerialize(hum), HumanName.class, false);
						if(add.getFamily()!= null) {
							p.setLastName(add.getFamily());
						}
						if(add.getGiven()!= null && !add.getGiven().isEmpty()) {
							p.setFirstName(add.getGiven().get(0));
						}
					
				});
			}
		}
		if(json.getAddress()!= null) {
			if(json.getAddress().size()>0) {
			List<com.example.demo.bean.Address> address = json.getAddress();
			List<Address> listAdd = new ArrayList<>();
				   for (int i=0;i<address.size();i++){ 
				    com.example.demo.bean.Address a = address.get(i);
				    Address add = JsonUtil.getJackson2DeserializedObject(JsonUtil.deepSerialize(a), Address.class, false);
				    listAdd.add(add);
				   } 
			p.setAddress(listAdd);
			
			}
		}
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		if(json.getBirthDate()!= null) {
		//Date birthDate = formatter.parse(json.getBirthDate());	
		p.setBirthDate(json.getBirthDate());
		}
		if(json.getGender()!=null) {
			p.setGender(Gender.valueOf(json.getGender()));
		}
		if(json.getDeptId()!=null) {
			p.setDeptId(json.getDeptId());
		}
		}
		return personRepository.save(p);
		 
		}catch (Exception e) {
			log.error(e.getMessage());
			return null;// TODO: handle exception
		}
		
	}

	@Override
	public PersonOutput update(PersonDetails json) {
		// TODO Auto-generated method stub
		try {
			Optional<Person> personExists = personRepository.findById(json.getId());
			Person p = personExists.get();
			if(Objects.nonNull(json) && Objects.nonNull(p)) {
			p.setId("PERSON_"+Calendar.getInstance().getTimeInMillis());
			log.info("in");
			if(json.getName()!= null) {
				log.info("in1");
				if(json.getName().size()>0) {
					
					 List<Name> name = json.getName();
					 name.forEach( hum ->{
						 
						 HumanName add = JsonUtil.getJackson2DeserializedObject(JsonUtil.deepSerialize(hum), HumanName.class, false);
							if(add.getFamily()!= null) {
								p.setLastName(add.getFamily());
							}
							if(add.getGiven()!= null && !add.getGiven().isEmpty()) {
								p.setFirstName(add.getGiven().get(0));
							}
						
					});
				}
			}
			if(json.getAddress()!= null) {
				if(json.getAddress().size()>0) {
				List<com.example.demo.bean.Address> address = json.getAddress();
				List<Address> listAdd = new ArrayList<>();
					   for (int i=0;i<address.size();i++){ 
					    com.example.demo.bean.Address a = address.get(i);
					    Address add = JsonUtil.getJackson2DeserializedObject(JsonUtil.deepSerialize(a), Address.class, false);
					    listAdd.add(add);
					   } 
				p.setAddress(listAdd);
				
				}
			}
			//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			if(json.getBirthDate()!= null) {
			//Date birthDate = formatter.parse(json.getBirthDate());	
			p.setBirthDate(json.getBirthDate());
			}
			if(json.getGender()!=null) {
				p.setGender(Gender.valueOf(json.getGender()));
			}
			if(json.getDeptId()!=null) {
				p.setDeptId(json.getDeptId());
			}
			}
			personRepository.save(p);
			return null;
			}catch (Exception e) {
				log.error(e.getMessage());
				return null;// TODO: handle exception
			}
			
	}

	@Override
	public PersonOutput search(String namePart) {
		
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny("^"+namePart);
		PersonOutput p = new PersonOutput();
		p.setPerson(personRepository.findByFirstNameStartingWith(namePart));
		p.setSuccess(true);
		return p;
	}

	@Override
	public PersonOutput findByOrg(String id) {
		// TODO Auto-generated method stub
		PersonOutput p = new PersonOutput();
		p.setPerson(personRepository.findByDeptId(id));
		p.setSuccess(true);
		return p;
	}

}
