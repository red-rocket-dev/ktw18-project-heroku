package pl.sda.project.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.project.entity.UserEntity;
import pl.sda.project.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void save(UserEntity userEntity) {
        String password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        userEntity.setPrivilage("user");
        userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> maybeUser = userRepository.findByMail(username);
        if(maybeUser.isPresent()) {
            return maybeUser.get();
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
