package flightbooking.microservices.accountmanagerservice.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "permissions")
public class Permission implements Serializable {

    @Id
    @Column
    private String permissionName;
}
