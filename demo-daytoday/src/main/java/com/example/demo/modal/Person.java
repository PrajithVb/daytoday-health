package com.example.demo.modal;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.util.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@Id
	public String id;
	@TextIndexed
	private String firstName;
	private String lastName;
	private Gender gender;
	private String birthDate;
	private List<Address> address;
	@Indexed
	private String deptId;
	private List<HumanName> humanName;
	

}
