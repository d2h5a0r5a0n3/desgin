package com.learn.test.service;

import com.learn.test.document.UserDocument;
import com.learn.test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserEsService {
    private final UserRepository userRepository;
    public void createUser(String name, String email){
        UserDocument user = UserDocument.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .email(email)
                .emailVerified(false)
                .active(false)
                .build();
        userRepository.save(user);
        System.out.println("ES: User created " + email);
    }
    public void verifyEmail(String email){
        UserDocument user = userRepository.findByEmail(email).orElseThrow();
        user.setEmailVerified(true);
        userRepository.save(user);
    }

    public void saveOtp(String email, int otp){
        UserDocument user = userRepository.findByEmail(email).orElseThrow();
        user.setOtp(otp);
        userRepository.save(user);
    }

    public boolean verifyOtp(String email, int enteredOtp){
        UserDocument user = userRepository.findByEmail(email).orElseThrow();
        return user.getOtp() == enteredOtp;
    }

    public void activate(String email){
        UserDocument user = userRepository.findByEmail(email).orElseThrow();
        user.setActive(true);
        userRepository.save(user);
    }
}