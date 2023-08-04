package flightbooking.microservices.accountmanagerservice._presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.microservices.accountmanagerservice._application.dto.RoleNameRequestBody;

@RestController
@RequestMapping(value = "/accounts", produces = "application/json")
public interface RoleManageInterface {

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResponseEntity<?> createRole(
        @RequestBody RoleNameRequestBody payload);

    @RequestMapping(value = "/role", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRole(
        @RequestBody RoleNameRequestBody payload);
}
