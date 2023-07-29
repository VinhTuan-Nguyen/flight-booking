package flightbooking.microservices.accountmanagerservice.implementations;

import flightbooking.microservices.accountmanagerservice.controllers.RegisterControllers;
import flightbooking.microservices.accountmanagerservice.models.dto.SuccessResponse;
import flightbooking.microservices.accountmanagerservice.models.entities.Profile;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ImplRegister implements RegisterControllers {

    public ResponseEntity<SuccessResponse> accountRegister(@Valid @RequestBody Profile profile) {

        return ResponseEntity.ok(new SuccessResponse());
    }
}
