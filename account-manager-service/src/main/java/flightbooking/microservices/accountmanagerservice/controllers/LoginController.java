
package flightbooking.microservices.accountmanagerservice.controllers;

import javax.validation.Valid;
import flightbooking.microservices.accountmanagerservice.controllers.model.AccountInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(value = "/login", produces = "application/json")
public interface LoginController {


    /**
     * No description
     * 
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createAccountInfo(
        @Valid
        @RequestBody
        AccountInfo accountInfo);

}
