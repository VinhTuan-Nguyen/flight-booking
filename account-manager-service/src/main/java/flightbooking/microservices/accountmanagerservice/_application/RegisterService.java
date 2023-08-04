package flightbooking.microservices.accountmanagerservice._application;

import flightbooking.microservices.accountmanagerservice._application.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice._application.dto.internalLoginForm;
import flightbooking.microservices.accountmanagerservice._application.dto.RegisterFormRequestBody;
import flightbooking.microservices.accountmanagerservice._application.dto.UserRegisterResponse;
import flightbooking.microservices.accountmanagerservice._data.dao.Profile;
import flightbooking.microservices.accountmanagerservice._data.dao.User;
import flightbooking.microservices.accountmanagerservice._data.service.ProfileService;
import flightbooking.microservices.accountmanagerservice._data.service.UserService;
import flightbooking.microservices.accountmanagerservice._presentation.RegisterInterface;
import net.bytebuddy.utility.RandomString;

import java.time.LocalDateTime;

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

        RandomString string = new RandomString(13);

        String userId = "User_" + string.nextString().toUpperCase();
        if (profileService.existsByEmail(payload.getEmail())) {

            CustomResponse newResponse = new CustomResponse();
            newResponse.setStatus("BAD REQUEST");
            newResponse.setMessage("This User Is Existing");
            newResponse.setTimeStamp(LocalDateTime.now());

            return ResponseEntity.status(400).body(newResponse);

        } else {
            UserRegisterResponse newResponse = new UserRegisterResponse();
            if (!userService.isExisting(userId)) {

                Profile profile = new Profile(payload.getEmail(), userId, payload.getFirstName(), payload.getLastName(),
                        payload.getDayOfBirth(), payload.getIdNumber(), payload.getRegion(), payload.getCity(),
                        payload.getStreet(), payload.getAvt());

                profileService.register(profile);
                User user = (User) userService.register(profile.getProfileId());
                newResponse.setLoginInfo(new internalLoginForm(user.getUserId(), user.getPassword()));

            } else
                internalRegister(payload);

            newResponse.setStatus("CREATED");
            newResponse.setMessage("This User Created Successfully");
            newResponse.setTimeStamp(LocalDateTime.now());
            return ResponseEntity.status(201).body(newResponse);
        }
    }
}
