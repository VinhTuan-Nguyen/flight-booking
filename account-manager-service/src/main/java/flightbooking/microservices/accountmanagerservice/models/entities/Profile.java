package flightbooking.microservices.accountmanagerservice.models.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity(name = "profiles")
public class Profile implements Serializable {

    @Id
    @Column
    @NotNull(message = "This is a madantory field")
    private Long profileId;

    @Column
    @NotNull(message = "This is a madantory field")
    private String firstName;
    @Column
    @NotNull(message = "This is a madantory field")
    private String lastName;
    @Column
    private LocalDate dayOfBirth;
    @Column
    private String idNumber;
    @Column
    @Email(message = "this isn't an correct email address")
    @NotNull
    @NotNull(message = "This is a madantory field")
    private String email;
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
