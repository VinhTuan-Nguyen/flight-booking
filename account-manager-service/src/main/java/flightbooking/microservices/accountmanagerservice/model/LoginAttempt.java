package flightbooking.microservices.accountmanagerservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "LoginAttempts")
public class LoginAttempt implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long userId;
    @Column
    private String ipAddress;
    @Column
    private LocalDateTime timeLogin;
}
