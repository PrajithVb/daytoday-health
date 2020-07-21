package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.output.OrgOutput;
import com.example.demo.util.Paths;

@RestController
@RequestMapping(Paths.ORG)
public class DepartmentController {
	
	
	
	public ResponseEntity<OrgOutput> createOrg(){
		return ResponseEntity.ok(new OrgOutput());
	}
	public ResponseEntity<List<OrgOutput>> getAll(){
		return ResponseEntity.ok(new ArrayList<OrgOutput>());
	}
	public ResponseEntity<OrgOutput> updateOrg(){
		return ResponseEntity.ok(new OrgOutput());
	}
	public ResponseEntity<OrgOutput> getOrgByName(){
		return ResponseEntity.ok(new OrgOutput());
	}

}
