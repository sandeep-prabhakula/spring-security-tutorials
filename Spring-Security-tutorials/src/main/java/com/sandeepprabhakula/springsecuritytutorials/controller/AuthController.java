package com.sandeepprabhakula.springsecuritytutorials.controller;

import com.sandeepprabhakula.springsecuritytutorials.data.UserInfo;
import com.sandeepprabhakula.springsecuritytutorials.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Security Tutorials";
    }

    @GetMapping("/login")
    public String login(){
        return "Sign in with your credentials";
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody UserInfo userInfo){
        return userService.signUp(userInfo);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin(){
        return "Welcome admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String user(){
        return "Welcome user";
    }
}
