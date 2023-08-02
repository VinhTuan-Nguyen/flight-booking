package flightbooking.microservices.accountmanagerservice._data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, String> {}
