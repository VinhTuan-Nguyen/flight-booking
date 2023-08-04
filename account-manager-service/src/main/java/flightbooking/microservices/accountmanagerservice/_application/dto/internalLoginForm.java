package flightbooking.microservices.accountmanagerservice._application.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class internalLoginForm {

    @NotNull(message = "This is a madantory field")
    private String userId;

    @NotNull(message = "This is a madantory field")
    private String password;
}
