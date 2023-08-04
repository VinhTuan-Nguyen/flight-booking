package flightbooking.microservices.accountmanagerservice._application;

import java.security.MessageDigest;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import flightbooking.microservices.accountmanagerservice._application.dto.CustomResponse;
import flightbooking.microservices.accountmanagerservice._application.dto.internalLoginForm;
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

        public static String encryptPassword(String password, String salt) {
                String encrypt = password + salt;
                try {
                        byte[] dataBytes = encrypt.getBytes("UTF-8");
                        MessageDigest md = MessageDigest.getInstance("SHA-1");
                        encrypt = Base64.encodeBase64String(md.digest(dataBytes));
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return encrypt;
        }

        @Override
        public ResponseEntity<CustomResponse> updatePassword(
                        @Valid @RequestBody PassResetRequestBody payload,
                        @PathVariable String userId,
                        @RequestParam String type,
                        HttpServletRequest request) {

                User user = userService.findByUserId(userId);
                internalLoginForm loginUser = new internalLoginForm(payload.getUserId(), payload.getCurrentPass());
                CustomResponse newResponse = new CustomResponse();
                String encrypted = encryptPassword(payload.getNewPass(), user.getSalt());
                int statusInt = 0;
                switch (type.toLowerCase()) {
                        case "update":
                                if (userService.authenticate(loginUser)) {
                                        user.setPassword(encrypted);
                                        loggerWrite(payload, user, request, type);
                                        userService.update(user);
                                        statusInt = 200;
                                        newResponse.setStatus("SUCCESS");
                                        newResponse.setMessage("Password Updated Successfully");
                                        break;
                                } else {
                                        statusInt = 401;
                                        newResponse.setStatus("UNAUTHORIZED");
                                        newResponse.setMessage("Can not Authenticate This User");
                                        break;
                                }
                        case "reset":
                                if (payload.getUserRequestId().toLowerCase() == "admin") {
                                        user.setPassword(encrypted);
                                        loggerWrite(payload, user, request, type);
                                        userService.update(user);
                                        newResponse.setStatus("SUCCESS");
                                        newResponse.setMessage("Password Updated Successfully");
                                        break;
                                }
                }

                newResponse.setTimeStamp(LocalDateTime.now());
                return ResponseEntity.status(statusInt).body(newResponse);
        }

        private void loggerWrite(PassResetRequestBody payload, User user, HttpServletRequest request, String type) {
                payload.setCurrentPass(encryptPassword(payload.getCurrentPass(), user.getSalt()));
                payload.setNewPass(encryptPassword(payload.getNewPass(), user.getSalt()));
                PassReset log = new PassReset(
                                request.getHeader("X-Forward-For") == null ? request.getRemoteAddr()
                                                : request.getHeader("X-Forward-For"),
                                payload.getUserRequestId(),
                                payload.getUserId(),
                                payload.getCurrentPass(),
                                payload.getNewPass(),
                                LocalDateTime.now(),
                                type);

                passResetService.createLog(log);
        }
}
