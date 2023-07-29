package flightbooking.microservices.accountmanagerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.microservices.accountmanagerservice.dto.RegisterRequestBody;

@RestController
@RequestMapping(value = "/accounts", produces = "application/json")
public interface RegisterController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> accountRegister(@RequestBody RegisterRequestBody payload);
}
