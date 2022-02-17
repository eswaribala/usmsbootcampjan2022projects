package com.usbootcamp.paymentapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usbootcamp.paymentapi.models.Payment;

public interface PaymentRepo extends MongoRepository<Payment,Long> {

}
