package flightbooking.microservices.accountmanagerservice._data.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.microservices.accountmanagerservice._data.dao.LoginAttempt;


public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, String> {}
