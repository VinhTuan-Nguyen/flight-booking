package flightbooking.microservices.accountmanagerservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.microservices.accountmanagerservice.dto.PassResetRequestBody;

@RestController
@RequestMapping(value = "/accounts", produces = "application/json")
public interface PassResetController {

    @RequestMapping(value = "/reset-pass", method = RequestMethod.PUT)
    public ResponseEntity<?> create(@RequestBody PassResetRequestBody payload, HttpServletRequest request);

}
