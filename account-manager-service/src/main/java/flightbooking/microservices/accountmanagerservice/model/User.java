package flightbooking.microservices.accountmanagerservice.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "users")
@NoArgsConstructor
public class User implements Serializable{

    @Id
    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "profileId")
    private Profile profile;

    public User (Long userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
