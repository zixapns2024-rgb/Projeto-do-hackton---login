package br.com.equipe3.sistemaacademico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // desativa csrf (importante pra API)
            .cors(cors -> {}) // habilita CORS
            .authorizeHttpRequests(auth -> auth
            	    .anyRequest().permitAll()
            );

        return http.build();
    }
}
