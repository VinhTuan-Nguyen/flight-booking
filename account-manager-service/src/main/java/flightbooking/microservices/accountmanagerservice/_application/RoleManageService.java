package flightbooking.microservices.accountmanagerservice._application;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice._application.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice._application.dto.RoleNameRequestBody;
import flightbooking.microservices.accountmanagerservice._data.dao.Role;
import flightbooking.microservices.accountmanagerservice._data.service.RoleService;
import flightbooking.microservices.accountmanagerservice._presentation.RoleManageInterface;

@Service
public class RoleManageService implements RoleManageInterface {
    @Autowired
    RoleService roleService;

    @Override
    public ResponseEntity<?> createRole(RoleNameRequestBody payload) {

        if (roleService.existsByRoleName(payload.getRoleName())) {
            CustomResponse newResponse = new CustomResponse(
                    "BAD REQUEST",
                    "The Role Is Existing",
                    LocalDateTime.now());
            return ResponseEntity.status(400).body(newResponse);

        } else {
            Role role = new Role(payload.getRoleName());
            roleService.createRole(role);
            CustomResponse newResponse = new CustomResponse(
                    "SUCCESS",
                    "The Role Created Successfully",
                    LocalDateTime.now());
            return ResponseEntity.status(201).body(newResponse);
        }
    }

    @Override
    public ResponseEntity<?> deleteRole(RoleNameRequestBody payload) {

        if (roleService.existsByRoleName(payload.getRoleName())) {
            Role role = new Role(payload.getRoleName());
            roleService.deleteRole(role);
            CustomResponse newResponse = new CustomResponse(
                    "SUCCESS",
                    "The Role Deleted Successfully",
                    LocalDateTime.now());
            return ResponseEntity.status(201).body(newResponse);

        } else {
            CustomResponse newResponse = new CustomResponse(
                    "BAD REQUEST",
                    "The Role Isn't Existing",
                    LocalDateTime.now());
            return ResponseEntity.status(400).body(newResponse);
        }
    }

}
