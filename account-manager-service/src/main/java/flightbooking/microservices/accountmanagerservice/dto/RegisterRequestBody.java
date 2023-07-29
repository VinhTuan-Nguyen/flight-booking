package flightbooking.microservices.accountmanagerservice.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequestBody {

    @NotNull(message = "This is a madantory field")
    private Long profileId;

    @NotNull(message = "This is a madantory field")
    private String firstName;

    @NotNull(message = "This is a madantory field")
    private String lastName;

    private LocalDate dayOfBirth;

    private String idNumber;

    @Email(message = "this isn't an correct email address")
    @NotNull(message = "This is a madantory field")
    private String email;

    private String region;

    private String city;

    private String street;

    private Byte[] avt;

    @NotNull(message = "This is a madantory field")
    private String password;
}
