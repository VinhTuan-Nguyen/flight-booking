package flightbooking.microservices.accountmanagerservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.microservices.accountmanagerservice.requestbodies.LoginForm;


@RestController
@RequestMapping( value = "/accounts", produces = "application/json")
public interface RegisterControllers {

    public ResponseEntity<?> accountRegister(
        @RequestBody LoginForm form);
}
