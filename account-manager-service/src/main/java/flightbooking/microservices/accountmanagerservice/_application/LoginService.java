package flightbooking.microservices.accountmanagerservice._application;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import flightbooking.microservices.accountmanagerservice._application.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice._application.dto.internalLoginForm;
import flightbooking.microservices.accountmanagerservice._data.dao.Profile;
import flightbooking.microservices.accountmanagerservice._data.dao.User;
import flightbooking.microservices.accountmanagerservice._data.service.ProfileService;
import flightbooking.microservices.accountmanagerservice._data.service.UserService;
import flightbooking.microservices.accountmanagerservice._presentation.LoginInterface;

@Service
public class LoginService implements LoginInterface {
    @Autowired
    UserService userService;
    @Autowired
    ProfileService profileService;

    User user = new User();

    @Override
    public ResponseEntity<CustomResponse> internalLogin(@Valid @RequestBody internalLoginForm payload) {
        internalLoginForm loginUser = new internalLoginForm(payload.getUserId(), payload.getPassword());

        if (userService.authenticate(loginUser)) {

            CustomResponse newResponse = new CustomResponse(
                    "ACCEPTED",
                    "Login Successfully",
                    LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(newResponse);
        } else {

            CustomResponse newResponse = new CustomResponse(
                    "UNAUTHORIZED",
                    "userId Or password went wrong",
                    LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(newResponse);
        }
    }

    @Override
    public ResponseEntity<?> externalLogin() {
        // To Do SomeThing Here
        if(profileService.isExisting("emailAddress")) {
            Profile profile = new Profile();
            //profileService.register(profile);
            profile.toString();
        }
        CustomResponse newResponse = new CustomResponse(
                "SUCCESS",
                "Login Successfully",
                LocalDateTime.now());
        return ResponseEntity.status(200).body(newResponse);
    }
}
