package com.example.demo.service;

import com.example.demo.bean.OrgDetails;
import com.example.demo.modal.Organization;
import com.example.demo.output.OrgOutput;
import com.google.gson.JsonObject;

public interface OrgApiService {
	
	public Organization create(OrgDetails json );
	public Organization update(OrgDetails json );
	public OrgOutput search(String name );
	public OrgOutput findAll();

}
