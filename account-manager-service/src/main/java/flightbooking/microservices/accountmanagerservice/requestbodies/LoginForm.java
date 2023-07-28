package flightbooking.microservices.accountmanagerservice.requestbodies;

import lombok.Data;

@Data
public class LoginForm {
    private Long userId;
    private String password;
}
