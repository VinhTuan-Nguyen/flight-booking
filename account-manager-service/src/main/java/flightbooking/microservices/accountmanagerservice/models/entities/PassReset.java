package flightbooking.microservices.accountmanagerservice.models.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "passResets")
public class PassReset implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private String ipAddress;
    @Column
    private Long userId;
    @Column
    private String oldPass;
    @Column
    private String newPass;
}
