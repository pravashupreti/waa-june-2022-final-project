package edu.miu.amp.repository;

import edu.miu.amp.domain.PasswordResetToken;
import org.springframework.data.repository.CrudRepository;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {
//    User findByEmail(String email);
    PasswordResetToken findByUserId(Long userId);
    PasswordResetToken findByToken(String token);
}
