package com.virtusa.traderapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@Entity
@Table(name = "Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="Bank_Id")
	private long bankId;
    @Column(name="Bank_Name",length = 50,nullable = false)
	private String bankName;
    @Column(name="Address",length = 150,nullable = false)
	private String address;
}
