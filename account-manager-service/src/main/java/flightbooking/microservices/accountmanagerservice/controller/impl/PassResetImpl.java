package flightbooking.microservices.accountmanagerservice.controller.impl;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import flightbooking.microservices.accountmanagerservice.controller.PassResetController;
import flightbooking.microservices.accountmanagerservice.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice.dto.PassResetRequestBody;
import flightbooking.microservices.accountmanagerservice.model.PassReset;
import flightbooking.microservices.accountmanagerservice.model.User;
import flightbooking.microservices.accountmanagerservice.service.PassResetService;
import flightbooking.microservices.accountmanagerservice.service.UserService;

@Service
public class PassResetImpl implements PassResetController {
    @Autowired
    UserService userService;
    @Autowired
    PassResetService passResetService;

    @Override
    public ResponseEntity<CustomResponse> create(@Valid @RequestBody PassResetRequestBody payload,
            HttpServletRequest request) {
        if (userService.isExisting(payload.getUserId()) == true) {

            User user = new User(
                    payload.getUserId(),
                    payload.getNewPass());

            userService.update(user);

            PassReset log = new PassReset(
                    request.getHeader("X-Forward-For") == null ? request.getRemoteAddr()
                            : request.getHeader("X-Forward-For"),
                    payload.getUserId(),
                    payload.getOldPass(),
                    payload.getNewPass(),
                    LocalDateTime.now(),
                    payload.getOldPass() == "" ? "new" : "update");

            passResetService.createLog(log);

            CustomResponse newResponse = new CustomResponse(
                    "SUCCESS",
                    "Password Created Successfully",
                    LocalDateTime.now());

            return ResponseEntity.ok(newResponse);
        } else {

            CustomResponse newResponse = new CustomResponse(
                    "BAD REQUEST",
                    "This User Isn't Existing",
                    LocalDateTime.now());

            return ResponseEntity.badRequest().body(newResponse);
        }
    }
}
