package flightbooking.microservices.accountmanagerservice._presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.microservices.accountmanagerservice._application.dto.RegisterFormRequestBody;

@RestController
@RequestMapping(value = "/accounts", produces = "application/json")
public interface RegisterInterface {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> internalRegister(@RequestBody RegisterFormRequestBody payload);
}
