package flightbooking.microservices.accountmanagerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.microservices.accountmanagerservice.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{}