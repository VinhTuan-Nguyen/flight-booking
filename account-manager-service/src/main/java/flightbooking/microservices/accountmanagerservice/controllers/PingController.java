
package flightbooking.microservices.accountmanagerservice.controllers;

import flightbooking.microservices.accountmanagerservice.controllers.model.PingResponse;
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
public interface PingController {


    /**
     * No description
     *
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<PingResponse> getPingResponse();

}
