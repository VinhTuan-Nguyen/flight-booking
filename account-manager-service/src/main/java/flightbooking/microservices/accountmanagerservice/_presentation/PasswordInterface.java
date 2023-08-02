package flightbooking.microservices.accountmanagerservice._presentation;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.microservices.accountmanagerservice._application.dto.PassResetRequestBody;

@RestController
@RequestMapping(value = "/accounts/password", produces = "application/json")
public interface PasswordInterface {

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePassword(@RequestBody PassResetRequestBody payload, HttpServletRequest request);

    @RequestMapping(value = "/reset", method = RequestMethod.PUT)
    public ResponseEntity<?> resetPassword(@RequestBody PassResetRequestBody payload, HttpServletRequest request);
}
