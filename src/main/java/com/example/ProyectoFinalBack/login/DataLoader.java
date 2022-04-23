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

  @Override
  public void run(ApplicationArguments args) throws Exception {
      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
      String password = passwordEncoder.encode("passadmin");
      String password2 = passwordEncoder.encode("passuser");
      userRepository.save(new AppUser("admin", "admin", "admin@gmail.com", password, AppUserRole.ADMIN));
      userRepository.save(new AppUser("user", "user","user@gmail.com",password2, AppUserRole.USER));
  }

}