package edu.miu.amp.service;


import edu.miu.amp.dto.request.*;
import edu.miu.amp.dto.response.LoginResponse;
import edu.miu.amp.dto.response.UserRegistrationResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends CrudService<UserRegistrationRequest, UserRegistrationResponse, Long>{

    LoginResponse login(LoginRequest loginRequest);

    UserRegistrationResponse findByEmail(String email);


    UserUpdateDto update(Long id, UserUpdateDto userUpdateDto);

    void userIsActive(long id);

    void processForgotPassword(EmailRequest request);

    UserRegistrationResponse resetPassword(PasswordRequest passwordRequest, HttpServletRequest request);

    UserRegistrationResponse changePassword(PasswordRequest password, Long id);

}
