package flightbooking.microservices.accountmanagerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.microservices.accountmanagerservice.model.User;

public interface UserRepository extends JpaRepository <User, Long>{}
