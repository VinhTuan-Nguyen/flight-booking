package flightbooking.microservices.accountmanagerservice._data.dao;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfileRepository extends JpaRepository<Profile, String>{
    boolean existsByEmail(String email);
}