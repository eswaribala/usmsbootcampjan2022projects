package com.virtusa.traderapi.models;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class FullName implements Serializable{
	
	private String firstName;

	private String lastName;
	
	private String middleName;

}
