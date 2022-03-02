package com.virtusa.policyapi.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PolicyHolder")
public class PolicyHolder {
	@Id
	@Column(name="Mobile_No")
	private long mobileNo;
	@Embedded
	private FullName fullName;
	@Enumerated(EnumType.STRING)
	@Column(name="Gender")
	private Gender gender;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="DOB")
	private LocalDate dob;
	@Column(name="Adhar_Card",nullable = false,length = 100)
	private String adharCard;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(foreignKey = @ForeignKey(name = "Reg_No"), name = "Reg_No" )
	@ApiModelProperty(hidden = true)
	private Vehicle vehicle;

}
