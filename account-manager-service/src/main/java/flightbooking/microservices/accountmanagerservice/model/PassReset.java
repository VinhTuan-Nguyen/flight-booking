package flightbooking.microservices.accountmanagerservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "passResets")
public class PassReset implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false)
    private String ipAddress;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String oldPass;
    @Column(nullable = false)
    private String newPass;
    @Column(nullable = false)
    private LocalDateTime createdDate;
    @Column(nullable = false)
    private String type;

    public PassReset(String ipAddress, Long userId, String oldPass, String newPass, LocalDateTime createdDate,
            String type) {
        this.ipAddress = ipAddress;
        this.userId = userId;
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.createdDate = createdDate;
        this.type = type;
    }
}
