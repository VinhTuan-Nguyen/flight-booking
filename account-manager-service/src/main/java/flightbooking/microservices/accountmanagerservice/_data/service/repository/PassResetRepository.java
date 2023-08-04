package flightbooking.microservices.accountmanagerservice._data.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.microservices.accountmanagerservice._data.dao.PassReset;

public interface PassResetRepository extends JpaRepository<PassReset, Long>{}
