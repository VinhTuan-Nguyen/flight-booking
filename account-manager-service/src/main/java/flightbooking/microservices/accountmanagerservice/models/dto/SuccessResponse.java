package flightbooking.microservices.accountmanagerservice.models.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SuccessResponse {
    String status = "SUCCESS";
    LocalDateTime timeStamp = LocalDateTime.now();
}
