package flightbooking.microservices.accountmanagerservice._presentation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flightbooking.microservices.accountmanagerservice._application.dto.PassResetRequestBody;

@RestController
@RequestMapping(value = "/accounts", produces = "application/json")
public interface PasswordInterface {

    @RequestMapping(value = "/{userId}/password", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePassword(
            @Valid @RequestBody PassResetRequestBody payload,
            @Valid @PathVariable String userId,
            @RequestParam String type,
            HttpServletRequest request);
}
