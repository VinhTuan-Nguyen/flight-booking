package flightbooking.microservices.accountmanagerservice._data.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "LoginAttempts")
@NoArgsConstructor
@AllArgsConstructor
public class LoginAttempt implements Serializable {

    @Id
    private String id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String ipAddress;

    @Column
    private LocalDateTime timeLogin;
}
