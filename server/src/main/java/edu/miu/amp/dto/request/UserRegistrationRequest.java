package edu.miu.amp.dto.request;

import edu.miu.amp.domain.Role;
import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String firstName;

    private String lastName;

    private Role role;

    private String email;

    private String password;
}
