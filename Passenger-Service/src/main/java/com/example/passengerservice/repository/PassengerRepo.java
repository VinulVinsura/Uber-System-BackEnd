package com.example.passengerservice.repository;

import com.example.passengerservice.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepo extends JpaRepository<Passenger,Integer> {
    Optional<Passenger> findByEmail(String email);
}
