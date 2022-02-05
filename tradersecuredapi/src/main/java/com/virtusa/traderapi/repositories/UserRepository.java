package com.virtusa.traderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.traderapi.models.User;




public interface UserRepository extends JpaRepository<User,String>{

}
