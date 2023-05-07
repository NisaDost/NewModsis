package com.example.Registation.Service.impl;

import com.NewModsis.DTO.LoginDto;
import com.NewModsis.DTO.UserDto;
import com.NewModsis.Entity.UserEntity;
import com.NewModsis.Model.User;
import com.NewModsis.Repository.UserRepository;
import com.NewModsis.Response.LoginResponse;
import com.NewModsis.Service.UserService;
import com.example.Registation.payload.response.LoginMesage;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        UserEntity user = new UserEntity(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword())
        );

        userRepository.save(user);

        return user.getFirstName();
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        String msg = "";
        UserEntity user = (UserEntity) userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getEncryptedPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> loggedInUser = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
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
