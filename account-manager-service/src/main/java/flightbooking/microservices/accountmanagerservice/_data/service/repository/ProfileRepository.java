package flightbooking.microservices.accountmanagerservice._data.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.microservices.accountmanagerservice._data.dao.Profile;


public interface ProfileRepository extends JpaRepository<Profile, String>{
    boolean existsByEmail(String email);
}