package flightbooking.microservices.accountmanagerservice.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "profiles")
public class Profile implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profileId;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dayOfBirth;
    @Column
    private String idNumber;
    @Column
    private String region;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private Byte[] avt;

    @OneToOne(mappedBy = "profile")
    private User user;
}
