package flightbooking.microservices.accountmanagerservice._data.dao;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "rolePermissions")
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission implements Serializable {

    @Id
    private Long id;

    @Column
    private String roleName;

    @Column
    private String permissionName;
}
