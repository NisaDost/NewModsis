package com.NewModsis.Service.Impl;
import com.NewModsis.DTO.LoginDto;
import com.NewModsis.DTO.UserDto;
import com.NewModsis.Entity.UserEntity;
import com.NewModsis.Repository.UserRepository;
import com.NewModsis.Response.LoginResponse;
import com.NewModsis.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String addUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);

        return user.getFirstName();
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        UserEntity user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<UserEntity> loggedInUser = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (loggedInUser.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password does not match", false);
            }
        } else {
            return new LoginResponse("Email does not exist", false);
        }
    }
}
