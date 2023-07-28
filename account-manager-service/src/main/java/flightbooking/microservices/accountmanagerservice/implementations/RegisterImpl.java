package flightbooking.microservices.accountmanagerservice.implementations;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import flightbooking.microservices.accountmanagerservice.controllers.RegisterControllers;
import flightbooking.microservices.accountmanagerservice.requestbodies.LoginForm;

@Service
public class RegisterImpl implements RegisterControllers {

    @Transactional
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> accountRegister(
        @RequestBody LoginForm form) {
            return ResponseEntity.ok("{\"message\":\"Successfully\"}");
    }
}
