package flightbooking.microservices.accountmanagerservice.models.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "rolePermissions")
public class RolePermission implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private String roleName;

    @Column
    private String permissionName;
}
