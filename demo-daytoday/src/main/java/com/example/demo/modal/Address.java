package com.example.demo.modal;

import java.util.Date;
import java.util.List;

import com.example.demo.util.Gender;
import com.example.demo.util.Type;
import com.example.demo.util.Use;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Address {
	
	private Use use;
	private Type type;
	private String text;
	private List<String> line;
	private String city;
	private String district;
	private String country;
	private String state;
	private String postalCode;
	private Period period;

}
