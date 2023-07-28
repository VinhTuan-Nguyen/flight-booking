
package flightbooking.microservices.accountmanagerservice.controllers;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
public interface PingController {
    /**
     * Get Health Check Response Status
     *
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> getPingResponse();
}
