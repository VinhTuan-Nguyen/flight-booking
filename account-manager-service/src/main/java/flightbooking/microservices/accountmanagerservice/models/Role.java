package flightbooking.microservices.accountmanagerservice.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "roles")
public class Role implements Serializable{

    @Id
    @Column
    private String roleName;
}
