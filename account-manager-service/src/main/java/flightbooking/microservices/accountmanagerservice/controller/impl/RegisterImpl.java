package flightbooking.microservices.accountmanagerservice.controller.impl;

import flightbooking.microservices.accountmanagerservice.controller.RegisterController;
import flightbooking.microservices.accountmanagerservice.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice.dto.RegisterRequestBody;
import flightbooking.microservices.accountmanagerservice.model.Profile;
import flightbooking.microservices.accountmanagerservice.model.User;
import flightbooking.microservices.accountmanagerservice.service.ProfileService;
import flightbooking.microservices.accountmanagerservice.service.UserService;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RegisterImpl implements RegisterController {
    @Autowired
    ProfileService profileService;
    @Autowired
    UserService userService;

    public ResponseEntity<CustomResponse> accountRegister(@Valid @RequestBody RegisterRequestBody payload) {

        if (userService.isExisting(payload.getProfileId()) == true) {

            CustomResponse newResponse = new CustomResponse(
                    "BAD REQUEST",
                    "This User Is Existing",
                    LocalDateTime.now());

            return ResponseEntity.badRequest().body(newResponse);
        } else {

            Profile profile = new Profile(
                    payload.getProfileId(),
                    payload.getFirstName(),
                    payload.getLastName(),
                    payload.getDayOfBirth(),
                    payload.getIdNumber(),
                    payload.getEmail(),
                    payload.getRegion(),
                    payload.getCity(),
                    payload.getStreet(),
                    payload.getAvt());
            profileService.register(profile);

            User user = new User(
                    payload.getProfileId(),
                    payload.getPassword());
            userService.update(user);

            CustomResponse newResponse = new CustomResponse(
                    "SUCCESS",
                    "This User Created",
                    LocalDateTime.now());

            return ResponseEntity.ok(newResponse);
        }
    }
}
