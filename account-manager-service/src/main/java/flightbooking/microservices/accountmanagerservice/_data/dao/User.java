package flightbooking.microservices.accountmanagerservice._data.dao;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String salt;
}
