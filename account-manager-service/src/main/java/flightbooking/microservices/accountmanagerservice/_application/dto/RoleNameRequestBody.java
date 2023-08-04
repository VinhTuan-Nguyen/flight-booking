package flightbooking.microservices.accountmanagerservice._application.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleNameRequestBody {

    @NotNull(message = "This field Is Mandatory")
    private String roleName;
}
