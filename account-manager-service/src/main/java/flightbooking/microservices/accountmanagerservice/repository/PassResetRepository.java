package flightbooking.microservices.accountmanagerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.microservices.accountmanagerservice.model.PassReset;

public interface PassResetRepository extends JpaRepository<PassReset, Long>{

}
