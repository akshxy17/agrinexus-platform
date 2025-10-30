package com.example.Farmer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.Farmer.security.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final MyUserDetailService userDetailService;

    @Autowired
    public SecurityConfig(MyUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // 🔓 Public endpoints (registration & login)
                .requestMatchers("/register", "/auth/login", "/swagger-ui/**", "/v3/api-docs/**").permitAll()

                // 👩‍🌾 Farmer API
                .requestMatchers(HttpMethod.GET, "/farmer/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/farmer/add").hasAnyRole("USER","ADMIN")
                // .requestMatchers(HttpMethod.PUT, "/farmer/**").hasRole("ADMIN")
                // .requestMatchers(HttpMethod.PATCH, "/farmer/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/farmer/**").hasRole("ADMIN")

                // 🌾 Crop API
                .requestMatchers(HttpMethod.GET, "/crop/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/crop/add").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/crop/**").hasRole("ADMIN")

                // 🐄 Cattle API
                .requestMatchers(HttpMethod.GET, "/cattle/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/cattle/add").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/cattle/**").hasRole("ADMIN")

                // 🏞️ Land API
                .requestMatchers(HttpMethod.GET, "/land/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/land/add").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/land/**").hasRole("ADMIN")

                // Default rule for any other requests
                .anyRequest().authenticated()
            )

            // Stateless session (since you’re preparing for JWT later)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // Simple HTTP Basic Authentication for now
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // ❗ Use BCryptPasswordEncoder in production
        return provider;
    }
}


