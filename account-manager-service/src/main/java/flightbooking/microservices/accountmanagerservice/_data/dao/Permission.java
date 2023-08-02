package flightbooking.microservices.accountmanagerservice._data.dao;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "permissions")
@NoArgsConstructor
@AllArgsConstructor
public class Permission implements Serializable {

    @Id
    @Column
    private String permissionName;
}
