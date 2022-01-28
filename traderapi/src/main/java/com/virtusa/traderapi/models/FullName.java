package com.virtusa.traderapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class FullName implements Serializable{
	@Column(name="First_Name",length = 50,nullable = false)
	private String firstName;
	@Column(name="Last_Name",length = 50,nullable = false)
	private String lastName;
	@Column(name="Middle_Name",length = 50,nullable = true)
	private String middleName;

}
