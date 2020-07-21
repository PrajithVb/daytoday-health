package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.OrgDetails;
import com.example.demo.modal.Organization;
import com.example.demo.output.OrgOutput;
import com.example.demo.service.OrgApiService;
import com.example.demo.util.Paths;
import com.google.gson.JsonObject;

@RestController
@RequestMapping(Paths.ORG)
public class DepartmentController {
	
	@Autowired
	OrgApiService orgApiService;
	
	@PostMapping(value = Paths.START)
	public ResponseEntity<Organization> createOrg(@RequestBody OrgDetails json){
		return ResponseEntity.ok(orgApiService.create(json));
	}
	@GetMapping(value = Paths.ALL)
	public ResponseEntity<OrgOutput> getAll(){
		return ResponseEntity.ok(orgApiService.findAll());
	}
	@PostMapping(value = Paths.UPDATE)
	public ResponseEntity<Organization> updateOrg(@RequestBody OrgDetails json){
		return ResponseEntity.ok(orgApiService.update(json));
	}
	@GetMapping(value = Paths.ORG_NAME)
	public ResponseEntity<OrgOutput> getOrgByName(@PathVariable String orgId){
		return ResponseEntity.ok(orgApiService.search(orgId));
	}

}
