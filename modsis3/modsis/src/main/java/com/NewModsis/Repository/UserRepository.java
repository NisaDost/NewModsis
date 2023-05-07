package com.NewModsis.Repository;

import com.NewModsis.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findOneByEmailAndPassword(String email, String password);

    UserEntity findByEmail(String email);
}
