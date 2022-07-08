package edu.miu.amp.service.impls;


import edu.miu.amp.domain.PasswordResetToken;
import edu.miu.amp.domain.User;
import edu.miu.amp.dto.request.*;
import edu.miu.amp.dto.response.LoginResponse;
import edu.miu.amp.dto.response.UserRegistrationResponse;
import edu.miu.amp.exception.custom.UserNotFoundException;
import edu.miu.amp.repository.PasswordResetTokenRepository;
import edu.miu.amp.repository.UserRepository;
import edu.miu.amp.security.JwtHelper;
import edu.miu.amp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtHelper jwtHelper;

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    private final JavaMailSender mailSender;

    @Override
    public UserRegistrationResponse save(UserRegistrationRequest userRegistration) {
        User user = modelMapper.map(userRegistration, User.class);
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user = userRepository.save(user);
//        user.setAccountCreatedAt(LocalDate.now());
        return modelMapper.map(user, UserRegistrationResponse.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserRegistrationResponse> findAll() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Login with user: {}",username);
        var user = userRepository.findByEmail(username);
        var users = (List<User>) userRepository.findAll();
        users = users
                .stream()
                .filter(u -> !u.getId().equals(user.getId())).toList();
        Type listType = new TypeToken<List<UserRegistrationResponse>>(){}.getType();
        return modelMapper.map(users,listType);
    }

    @Override
    public UserRegistrationResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User does not exist %s",id)));
        return modelMapper.map(userRepository.save(user), UserRegistrationResponse.class);
    }

    @Override
    public UserRegistrationResponse update(UserRegistrationRequest userRegistration, Long id) {
        User user = modelMapper.map(userRegistration, User.class);
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.setId(id);
        user = userRepository.save(user);
        return modelMapper.map(user, UserRegistrationResponse.class);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication= null;
        try {
            authentication =authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new UserNotFoundException("Bad Credentials");
        }
        String role = authentication.getAuthorities().stream().findFirst().get().getAuthority();
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail(), role);
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public UserRegistrationResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not Found");
        }
        return modelMapper.map(user, UserRegistrationResponse.class);
    }



    @Override
    public UserUpdateDto update(Long id, UserUpdateDto userUpdateDto) {
        var user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User does not exist %s",id)));
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        userRepository.save(user);
        return userUpdateDto;
    }

    @Override
    public void userIsActive(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User does not exist %s", id)));
        var status = user.isActive() ? false : true;
        user.setActive(status);
        userRepository.save(user);
    }

    public void processForgotPassword(EmailRequest request) {
        String email = request.getEmail();
        log.info("Sending email for user:",email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not Found");
        }
        String token = RandomString.make(30);
        try {
            this.createPasswordResetTokenForUser(user, token);
            String resetPasswordLink = "http://localhost:3000" + "/reset-password?token=" + token;
            sendEmail(email, resetPasswordLink);

        } catch (UnsupportedEncodingException | MessagingException e) {
            throw new MailSendException(String.format("Unable to send email to address: %s",email));
        }
    }

    @Override
    public UserRegistrationResponse resetPassword(PasswordRequest passwordRequest, HttpServletRequest request) {
         String token = request.getParameter("token");
         PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
         User user = passwordResetToken.getUser();
         user.setPassword(passwordEncoder.encode(passwordRequest.getPassword()));
         userRepository.save(user);
        return modelMapper.map(user, UserRegistrationResponse.class);
    }

    @Override
    public UserRegistrationResponse changePassword(PasswordRequest password, Long id) {
        User user = userRepository.findById(id).orElse(null);
        user.setPassword(passwordEncoder.encode(password.getPassword()));
        return modelMapper.map(user, UserRegistrationResponse.class);
    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);


        helper.setFrom("sachin8peace@gmail.com", "check it out");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<a href=\"" + link + "\">Change my password</a>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken tokenExist = passwordResetTokenRepository.findByUserId(user.getId());
        if(tokenExist != null) {
            tokenExist.setToken(token);
            passwordResetTokenRepository.save(tokenExist);
        }
        else {
            PasswordResetToken myToken = new PasswordResetToken(token, user);
            passwordResetTokenRepository.save(myToken);
        }

    }
}
