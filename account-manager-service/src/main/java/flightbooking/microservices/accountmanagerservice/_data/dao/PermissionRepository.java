package flightbooking.microservices.accountmanagerservice._data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {}
