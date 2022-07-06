package edu.miu.amp.repository;


import edu.miu.amp.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);


}
