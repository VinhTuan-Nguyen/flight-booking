package flightbooking.microservices.accountmanagerservice._data.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.microservices.accountmanagerservice._data.dao.Role;


public interface RoleRepository extends JpaRepository <Role, String>{
    boolean existsByRoleName(String roleName);
}
