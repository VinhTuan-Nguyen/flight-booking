package flightbooking.microservices.accountmanagerservice._application.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PassResetRequestBody {

    @NotNull(message = "This is a madantory field")
    private String userRequestId;

    @NotNull(message = "This is a madantory field")
    private String userId;

    @NotNull(message = "This is a madantory field")
    private String currentPass;

    @NotNull(message = "This is a madantory field")
    private String newPass;
}
