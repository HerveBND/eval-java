package org.example.evalbonnabaud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EvalBonnabaudApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvalBonnabaudApplication.class, args);
    }
    @Bean // L'usage est lancé avec cette option ! (en début d'exécution de l'APP)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
