package flightbooking.microservices.accountmanagerservice._data.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "passResets")
@NoArgsConstructor
@AllArgsConstructor
public class PassReset implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String ipAddress;

    @Column(nullable = false)
    private String createBy;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String oldPass;

    @Column(nullable = false)
    private String newPass;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private String type;

    public PassReset(String ipAddress, String createBy, String userId, String oldPass, String newPass,
            LocalDateTime createdDate, String type) {
        this.ipAddress = ipAddress;
        this.createBy = createBy;
        this.userId = userId;
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.createdDate = createdDate;
        this.type = type;
    }
}
