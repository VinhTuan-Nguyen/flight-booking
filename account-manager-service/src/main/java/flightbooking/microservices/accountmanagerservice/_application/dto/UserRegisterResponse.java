package flightbooking.microservices.accountmanagerservice._application.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {

    String status;

    String message;

    LocalDateTime timeStamp;

    internalLoginForm loginInfo;
}
