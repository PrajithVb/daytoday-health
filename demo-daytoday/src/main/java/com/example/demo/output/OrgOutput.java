package com.example.demo.output;

import com.example.demo.modal.ApiOutput;
import com.example.demo.modal.Organization;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrgOutput extends ApiOutput{

	public Organization org;
}
