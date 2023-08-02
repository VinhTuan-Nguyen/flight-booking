package flightbooking.microservices.accountmanagerservice._application;

import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import flightbooking.microservices.accountmanagerservice._application.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice._application.dto.LoginFormRequestBody;
import flightbooking.microservices.accountmanagerservice._data.dao.User;
import flightbooking.microservices.accountmanagerservice._data.service.UserService;
import flightbooking.microservices.accountmanagerservice._presentation.LoginInterface;

@Service
public class LoginService implements LoginInterface {
    @Autowired
    UserService userService;

    User user = new User();

    @Override
    public ResponseEntity<CustomResponse> internalLogin(@Valid @RequestBody LoginFormRequestBody payload) {

        user.setUserId(payload.getUserId());
        user.setPassword(payload.getPassword());

        if (userService.authenticate(user)) {

            CustomResponse newResponse = new CustomResponse(
                    "ACCEPTED",
                    "Login Successfully",
                    LocalDateTime.now());

            return ResponseEntity.status(200).body(newResponse);
        } else {

            CustomResponse newResponse = new CustomResponse(
                    "UNAUTHORIZED",
                    "userId Or password went wrong",
                    LocalDateTime.now());

            return ResponseEntity.status(401).body(newResponse);
        }
    }

    @Override
    public ResponseEntity<?> externalLogin(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        Map<String, Object> google = oAuth2AuthenticationToken.getPrincipal().getAttributes();
        System.out.print(google);
        return ResponseEntity.status(200).body(google);
    }
}
