package com.virtualexhibiton;

import com.virtualexhibiton.model.User;
import com.virtualexhibiton.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class VirtualexhibitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirtualexhibitionApplication.class, args);
    }

    @Bean
    public CommandLineRunner setupDefaultUser(UserRepository userRepository) {
        return args -> {
            Long adminCount = userRepository.countByUser_type_id(1);
            if (adminCount == 0) {
                User admin = new User();
                admin.setFirstname("jeeva");
                admin.setLastname("s");
                admin.setEmail("jeeva@gmail.com");
                admin.setMobile("123456789");
                admin.setPassword("Jeeva@123");
                admin.setProfile(new byte[1]);
                admin.setUser_type_id(1L);
                userRepository.save(admin);
            }
        };
    }
}
