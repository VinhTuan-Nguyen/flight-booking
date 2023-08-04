package flightbooking.microservices.accountmanagerservice._data.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import flightbooking.microservices.accountmanagerservice._data.dao.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {}
