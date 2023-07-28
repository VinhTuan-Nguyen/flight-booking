package flightbooking.microservices.accountmanagerservice.implementations;

import java.time.LocalDateTime;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice.controllers.PingController;

@Service
public class PingImplementation implements PingController {

    @Override
    public ResponseEntity<JSONObject> getPingResponse() {
        JSONObject response = buildHealthCheck();
        return ResponseEntity.ok(response);
    }

    private JSONObject buildHealthCheck() {
        JSONObject obj = new JSONObject();
        obj.put("status", "SUCCESS");
        obj.put("transaction", UUID.randomUUID());
        obj.put("timeStamp", LocalDateTime.now());
        obj.put("Info",new JSONObject().put("apiName", "Account Mangager Service"));
        obj.put("Info",new JSONObject().put("version", "1.0.0"));
        return obj;
    }
}
