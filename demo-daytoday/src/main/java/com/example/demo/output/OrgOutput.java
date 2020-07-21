package com.example.demo.output;

import java.util.List;

import com.example.demo.modal.ApiOutput;
import com.example.demo.modal.Organization;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrgOutput extends ApiOutput{

	public List<Organization> org;
	
	public OrgOutput(boolean success) {
		setSuccess(success);
	}
}
