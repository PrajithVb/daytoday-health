package com.example.demo.output;

import java.util.List;

import com.example.demo.modal.ApiOutput;
import com.example.demo.modal.Person;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PersonOutput extends ApiOutput{

	private List<Person> person;
	
	public PersonOutput ( boolean success) {
		setSuccess(success);
	}
}
