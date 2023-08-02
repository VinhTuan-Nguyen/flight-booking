package flightbooking.microservices.accountmanagerservice._application;

import flightbooking.microservices.accountmanagerservice._application.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice._application.dto.RegisterFormRequestBody;
import flightbooking.microservices.accountmanagerservice._application.dto.UserRegisterResponse;
import flightbooking.microservices.accountmanagerservice._data.dao.Profile;
import flightbooking.microservices.accountmanagerservice._data.dao.User;
import flightbooking.microservices.accountmanagerservice._data.service.ProfileService;
import flightbooking.microservices.accountmanagerservice._data.service.UserService;
import flightbooking.microservices.accountmanagerservice._presentation.RegisterInterface;

import java.time.LocalDateTime;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RegisterService implements RegisterInterface {
    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    public ResponseEntity<?> internalRegister(@Valid @RequestBody RegisterFormRequestBody payload) {

        Random rand = new Random();
        String userId = "User_" + String.valueOf(rand.nextInt(999999999));

        if (profileService.isExisting(payload.getEmail()) || userService.isExisting(userId)) {

            CustomResponse newResponse = new CustomResponse(
                    "BAD REQUEST",
                    "This User Is Existing",
                    LocalDateTime.now());

            return ResponseEntity.status(400).body(newResponse);
        } else {

            Profile profile = new Profile(
                    payload.getEmail(),
                    userId,
                    payload.getFirstName(),
                    payload.getLastName(),
                    payload.getDayOfBirth(),
                    payload.getIdNumber(),
                    payload.getRegion(),
                    payload.getCity(),
                    payload.getStreet(),
                    payload.getAvt());

            profileService.register(profile);
            User user = (User) userService.register(profile.getProfileId());

            UserRegisterResponse newResponse = new UserRegisterResponse(
                    "CREATED",
                    "This User Created Successfully",
                    LocalDateTime.now(),
                    user);

            return ResponseEntity.status(201).body(newResponse);
        }
    }
}
