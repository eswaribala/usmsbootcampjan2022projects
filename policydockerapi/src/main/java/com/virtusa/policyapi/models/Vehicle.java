package com.virtusa.policyapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Vehicle")
//Vehicle Details Captured
public class Vehicle {
    @Id
    @Column(name="Reg_No")
	private String regNo;
    @Column(name="Make",nullable = false,length = 100)
	private String make;
    @Column(name="Color",nullable = false,length = 100)
	private String color;
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="DOP")
    private LocalDate dop;
}
