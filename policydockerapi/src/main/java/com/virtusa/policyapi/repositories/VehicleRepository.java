package com.virtusa.policyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.policyapi.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,String>{

}
