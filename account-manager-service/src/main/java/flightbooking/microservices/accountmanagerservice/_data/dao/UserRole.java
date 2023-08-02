package flightbooking.microservices.accountmanagerservice._data.dao;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "userRoles")
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {

    @Id
    private String id;

    @Column
    private String userId;

    @Column
    private String roleName;
}
