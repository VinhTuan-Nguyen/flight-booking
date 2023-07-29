package flightbooking.microservices.accountmanagerservice.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PassResetRequestBody {

    @NotNull(message = "This is a madantory field")
    private Long userId;

    @NotNull(message = "This is a madantory field")
    private String oldPass;

    @NotNull(message = "This is a madantory field")
    private String newPass;
}
