package flightbooking.microservices.accountmanagerservice.implementations;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import flightbooking.microservices.accountmanagerservice.controllers.PingController;
import flightbooking.microservices.accountmanagerservice.controllers.model.Info;
import flightbooking.microservices.accountmanagerservice.controllers.model.PingResponse;
import flightbooking.microservices.accountmanagerservice.controllers.model.Status;

@Service
public class PingImplementation implements PingController {
    UUID uuid = new UUID(64, 64);
    Info info = new Info("Account Manager Service", "1.0.0");

    @Override
    public ResponseEntity<PingResponse> getPingResponse() {
        PingResponse response = new PingResponse();
        response.setStatus(Status.SUCCESS);
        response.setTransaction(uuid.toString());
        response.setTimeStamp(Date.valueOf(LocalDate.now()));
        response.setInfo(info);
        return ResponseEntity.ok(response);
    }

}
