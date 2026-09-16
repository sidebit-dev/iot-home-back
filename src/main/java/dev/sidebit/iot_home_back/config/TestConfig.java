package dev.sidebit.iot_home_back.config;

import dev.sidebit.iot_home_back.entities.User;
import dev.sidebit.iot_home_back.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456","988888888", true);
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456","988888888", true);

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
