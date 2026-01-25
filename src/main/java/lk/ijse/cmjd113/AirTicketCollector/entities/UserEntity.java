package lk.ijse.cmjd113.AirTicketCollector.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd113.AirTicketCollector.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
   @Id
    private String userId;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String phone;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookingEntity> bookings;
}
