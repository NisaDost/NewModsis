package com.NewModsis.Controller;

import com.NewModsis.DTO.LoginDto;
import com.NewModsis.DTO.UserDto;
import com.NewModsis.Response.LoginResponse;
import com.NewModsis.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDto UserDto) {
        String firstName = userService.addUser(UserDto);
        return firstName;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
}



