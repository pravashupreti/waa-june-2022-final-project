package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String userName;

    @Embedded
    @Nullable
    private Address address;
}
