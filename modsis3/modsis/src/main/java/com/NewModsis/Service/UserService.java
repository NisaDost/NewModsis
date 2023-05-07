package com.NewModsis.Service;

import com.NewModsis.DTO.LoginDto;
import com.NewModsis.DTO.UserDto;
import com.NewModsis.Response.LoginResponse;
 public interface UserService {
        String addUser(UserDto userDto);

        LoginResponse loginUser(LoginDto loginDto);
    }
