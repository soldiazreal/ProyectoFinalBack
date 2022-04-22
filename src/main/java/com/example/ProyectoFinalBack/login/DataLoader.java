package com.example.ProyectoFinalBack.login;

import com.example.ProyectoFinalBack.repository.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String Password = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String Password2 = passwordEncoder2.encode("password2");
        userRepository.save(new AppUser("admin", "passadmin", Password, "admin@gmail.com", AppUserRole.ADMIN));
        userRepository.save(new AppUser("user", "passuser", Password2, "user@gmail.com", AppUserRole.USER));
    }
}