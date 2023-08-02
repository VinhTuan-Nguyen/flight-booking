package flightbooking.microservices.accountmanagerservice._application;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import flightbooking.microservices.accountmanagerservice._application.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice._application.dto.PassResetRequestBody;
import flightbooking.microservices.accountmanagerservice._data.dao.PassReset;
import flightbooking.microservices.accountmanagerservice._data.dao.User;
import flightbooking.microservices.accountmanagerservice._data.service.PassResetService;
import flightbooking.microservices.accountmanagerservice._data.service.UserService;
import flightbooking.microservices.accountmanagerservice._presentation.PasswordInterface;

@Service
public class PasswordService implements PasswordInterface {
        @Autowired
        UserService userService;
        @Autowired
        PassResetService passResetService;

        User user = new User();

        @Override
        public ResponseEntity<CustomResponse> updatePassword(@Valid @RequestBody PassResetRequestBody payload,
                        HttpServletRequest request) {
                user.setUserId(payload.getUserId());
                user.setPassword(payload.getCurrentPass());
                if (userService.authenticate(user) == true) {
                        user.setPassword(payload.getNewPass());
                        userService.update(user);
                        loggerWrite(payload, request);
                        CustomResponse newResponse = new CustomResponse("SUCCESS", "Password Created Successfully",
                                        LocalDateTime.now());
                        return ResponseEntity.ok(newResponse);
                } else {
                        CustomResponse newResponse = new CustomResponse("UNAUTHORIZED",
                                        "Can Not Authenticate This User", LocalDateTime.now());
                        return ResponseEntity.status(401).body(newResponse);
                }
        }

        @Override
        public ResponseEntity<CustomResponse> resetPassword(@Valid @RequestBody PassResetRequestBody payload,
                        HttpServletRequest request) {

                if (true) {
                        CustomResponse newResponse = new CustomResponse("SUCCESS", "Password Changed Successfully",
                                        LocalDateTime.now());
                        return ResponseEntity.ok(newResponse);
                } else {
                        CustomResponse newResponse = new CustomResponse("FAILED",
                                        "Only Adminitrator Can Reset Users Password", LocalDateTime.now());
                        return ResponseEntity.badRequest().body(newResponse);
                }
        }

        public static String encryptPassword(String password){
                String encrypt = password;
                return encrypt;
        }

        private void loggerWrite(PassResetRequestBody payload, HttpServletRequest request) {

                PassReset log = new PassReset("",
                                request.getHeader("X-Forward-For") == null ? request.getRemoteAddr()
                                                : request.getHeader("X-Forward-For"),
                                payload.getUserRequestId(), payload.getUserId(), payload.getCurrentPass(),
                                payload.getNewPass(), LocalDateTime.now(),
                                payload.getCurrentPass() == "" ? "new" : "update");

                passResetService.createLog(log);
        }
}
