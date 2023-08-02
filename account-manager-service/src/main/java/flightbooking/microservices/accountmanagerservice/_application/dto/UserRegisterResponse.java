package flightbooking.microservices.accountmanagerservice._application.dto;

import java.time.LocalDateTime;

import flightbooking.microservices.accountmanagerservice._data.dao.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegisterResponse {

    String status;

    String message;

    LocalDateTime timeStamp;

    User loginInfo;
}
