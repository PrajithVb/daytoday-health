package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.OrgDetails;
import com.example.demo.modal.Address;
import com.example.demo.modal.Organization;
import com.example.demo.modal.Person;
import com.example.demo.output.OrgOutput;
import com.example.demo.repository.OrgRepository;
import com.example.demo.service.OrgApiService;
import com.example.demo.util.JsonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("orgApiService")
public class OrgServiceImpl implements OrgApiService {
	
	@Autowired
	OrgRepository orgRepository;

	@Override
	public Organization create(OrgDetails json) {
		
		Organization org = new Organization();
		if(Objects.nonNull(json)) {
			
				if(json.getAddress()!= null) {
					List<com.example.demo.bean.Address> address = json.getAddress();
					List<Address> listAdd = new ArrayList<>();
					   for (int i=0;i<address.size();i++){ 
					    com.example.demo.bean.Address a = address.get(i);
					    Address add = JsonUtil.getJackson2DeserializedObject(JsonUtil.deepSerialize(a), Address.class, false);
					    listAdd.add(add);
					   } 
					org.setAddress(listAdd);
					
					}
				if(json.getName()!= null) {
					org.setName(json.getName());
				}
				Organization organization= orgRepository.findByName(json.getName());
				
				if(Objects.nonNull(organization)) {
					
					org.setId(organization.getId());
				}else {
					org.setId("ORG_"+Calendar.getInstance().getTimeInMillis());
					
				}
				return orgRepository.save(org);
				
			}
		return org;
	}

	@Override
	public Organization update(OrgDetails json) {
		try {
		Optional<Organization> orgExists = orgRepository.findById(json.getId());
		Organization org = orgExists.get();
		if(Objects.nonNull(json) && Objects.nonNull(org)) {
			
				if(json.getAddress()!= null) {
					List<com.example.demo.bean.Address> address = json.getAddress();
					List<Address> listAdd = new ArrayList<>();
					   for (int i=0;i<address.size();i++){ 
					    com.example.demo.bean.Address a = address.get(i);
					    Address add = JsonUtil.getJackson2DeserializedObject(JsonUtil.deepSerialize(a), Address.class, false);
					    listAdd.add(add);
					   } 
					org.setAddress(listAdd);
					
					}
				if(json.getName()!= null) {
					org.setName(json.getName());
				}		
				return orgRepository.save(org);				
			}
		}catch (Exception e) {
			log.error(e.getMessage());
			Organization org = new Organization();
			return org;
		}
		return null;
		
	}

	@Override
	public OrgOutput search(String name) {
		// TODO Auto-generated method stub
		OrgOutput a = new OrgOutput();
		
		List<Organization> list= new ArrayList<>();
				list.add(orgRepository.findByName(name));
		
		a.setOrg(list);
		return a;
	}

	@Override
	public OrgOutput findAll() {
		// TODO Auto-generated method stub
		OrgOutput a = new OrgOutput();
		
		List<Organization> list= orgRepository.findAll();
		a.setOrg(list);
		return a;
	}

}
