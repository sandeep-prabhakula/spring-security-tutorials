package com.sandeepprabhakula.springsecurityjwt.controller;

import com.sandeepprabhakula.springsecurityjwt.data.UserInfo;
import com.sandeepprabhakula.springsecurityjwt.dto.AuthRequest;
import com.sandeepprabhakula.springsecurityjwt.service.JWTService;
import com.sandeepprabhakula.springsecurityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final JWTService jwtService;

    private final AuthenticationManager authMan;

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to JWT";
    }

    @GetMapping("/login")
    public String login() {
        return "Sign in with your credentials";
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody UserInfo userInfo) {
        return userService.signUp(userInfo);
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "Welcome Admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String user() {
        return "Welcome user";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication auth = authMan.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));
        if(auth.isAuthenticated())
        return jwtService.generateToken(authRequest.getEmail());

        else return"Invalid User";
    }
}
