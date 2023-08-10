package com.sandeepprabhakula.springsecuritytutorials.service;

import com.sandeepprabhakula.springsecuritytutorials.data.UserInfo;
import com.sandeepprabhakula.springsecuritytutorials.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public String signUp(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userRepository.save(userInfo);
        return "User added Successfully";
    }

}
