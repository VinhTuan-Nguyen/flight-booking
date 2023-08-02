package flightbooking.microservices.accountmanagerservice._data.dao;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "profiles")
@NoArgsConstructor
@AllArgsConstructor
public class Profile implements Serializable {

    @Id
    @Column
    @Email(message = "this isn't an correct email address")
    private String email;

    @Column
    @NotNull(message = "This is a madantory field")
    private String profileId;

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
    private String region;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private Byte[] avt;
}
