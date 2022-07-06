package edu.miu.amp.dto.response;

import edu.miu.amp.domain.Role;
import lombok.Data;

@Data
public class UserRegistrationResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private Role role;

    private boolean isActive;

    private String email;

}
