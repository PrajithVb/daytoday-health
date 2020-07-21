package com.example.demo.modal;

import java.util.Date;
import java.util.List;

import com.example.demo.util.Gender;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Period {
	
	private Date start;
	private Date end;

}
