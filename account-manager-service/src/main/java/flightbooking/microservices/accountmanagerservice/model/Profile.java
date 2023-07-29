package flightbooking.microservices.accountmanagerservice.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "profiles")
@NoArgsConstructor
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

    public Profile(Long profileId, String firstName, String lastName, LocalDate dayOfBirth, String idNumber,
            String email, String region, String city, String street, Byte[] avt) {
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.idNumber = idNumber;
        this.email = email;
        this.region = region;
        this.city = city;
        this.street = street;
        this.avt = avt;
    }
}
