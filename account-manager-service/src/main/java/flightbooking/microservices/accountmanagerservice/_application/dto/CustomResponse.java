package flightbooking.microservices.accountmanagerservice._application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponse {

    String status;

    String message;

    LocalDateTime timeStamp;
}
