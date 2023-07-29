package flightbooking.microservices.accountmanagerservice.controllers;

import flightbooking.microservices.accountmanagerservice.models.entities.Profile;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( value = "/accounts", produces = "application/json")
public interface RegisterControllers {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> accountRegister(@RequestBody Profile profile);
}
