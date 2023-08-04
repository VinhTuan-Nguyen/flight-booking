package flightbooking.microservices.accountmanagerservice._application.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalLoginForm {

    @Email(message = "this isn't an correct email address")
    @NotNull(message = "This is a madantory field")
    private String email;

    @NotNull(message = "This is a madantory field")
    private String firstName;

    @NotNull(message = "This is a madantory field")
    private String lastName;

    private LocalDate dayOfBirth;

    private String idNumber;

    private String region;

    private String city;

    private String street;

    private Byte[] avt;
}
