package com.example.demo.modal;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.example.demo.util.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class Person {
//	@Id
//	public String id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date birthDate;
	private List<Address> address;
	private String deptId;
	private List<HumanName> humanName;
	

}
