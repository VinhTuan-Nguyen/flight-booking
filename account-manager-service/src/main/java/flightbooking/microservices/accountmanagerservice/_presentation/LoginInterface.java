package flightbooking.microservices.accountmanagerservice._presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.microservices.accountmanagerservice._application.dto.internalLoginForm;

@RestController
@RequestMapping(value = "/accounts", produces = "application/json")
public interface LoginInterface {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> internalLogin(
            @RequestBody internalLoginForm payload);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<?> externalLogin();
}
