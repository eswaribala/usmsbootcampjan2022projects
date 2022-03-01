package com.virtusa.policyapi.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Policy")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Policy_Id")
	private long policyId;
	@Column(name="Insured_Sum")
	private long insuredSum;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="Start_Date")
	private LocalDate startDate;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="End_Date")
	private LocalDate endDate;
	@Enumerated(EnumType.STRING)
	@Column(name="Premium_Type")
	private PremiumType premiumType;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "Mobile_No"), name = "Mobile_No" )
	private PolicyHolder policyHolder;
	
}
