package flightbooking.microservices.accountmanagerservice.models.entities;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "userRoles")
public class UserRole implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String roleName;
}
