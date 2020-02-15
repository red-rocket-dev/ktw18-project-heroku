package pl.sda.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.project.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByMail(String mail);
}
