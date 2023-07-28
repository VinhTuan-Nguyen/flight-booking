
package flightbooking.microservices.accountmanagerservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * No description
 * (Generated with springmvc-raml-parser v.2.0.5)
 *
 */
@RestController
@Validated
@RequestMapping(value = "/accounts", produces = "application/json")
public interface AccountController {
    /**
     * Get All Users Account Info
     *
     */
    @RequestMapping(value = "/infomations", method = RequestMethod.GET)
    public ResponseEntity<?> getInfomations();
    /**
     * Get An User Infomations
     *
     */
    @RequestMapping(value = "/infomations/{user_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getInfomationsByUserId(
        @PathVariable(name = "user_id")
        String userId);

}
