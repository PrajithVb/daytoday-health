package com.example.demo.modal;

import java.util.Date;
import java.util.List;

import com.example.demo.util.Gender;
import com.example.demo.util.Type;
import com.example.demo.util.Use;
import com.example.demo.util.UseName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class HumanName {
	
	private UseName use;
	private String family;
	private String text;
	private List<String> given;
	private List<String> prefix;
	private List<String> suffix;
	private Period period;

}
