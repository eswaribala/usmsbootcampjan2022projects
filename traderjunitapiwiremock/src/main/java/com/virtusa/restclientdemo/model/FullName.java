package com.virtusa.restclientdemo.model;

import java.io.Serializable;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class FullName implements Serializable{
	
	private String firstName;
	
	private String lastName;

	private String middleName;

}
