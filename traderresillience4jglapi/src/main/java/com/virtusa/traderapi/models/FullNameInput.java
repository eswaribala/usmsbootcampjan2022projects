package com.virtusa.traderapi.models;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullNameInput implements Serializable{
	
	private String firstName;

	private String lastName;

	private String middleName;
}
