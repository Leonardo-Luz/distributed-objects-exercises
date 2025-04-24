package br.edu.ifrs.osorio.tads.aula0903.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsManager userDetailsService() {

        UserDetails visitante = User.builder()
                .username("visitante")
                .password(passwordEncoder().encode("123"))
                .roles("VISITANTE")
                .build();
        UserDetails professor = User.builder()
                .username("professor")
                .password(passwordEncoder().encode("123"))
                .roles("PROFESSOR")
                .build();
        UserDetails estudante = User.builder()
                .username("estudante")
                .password(passwordEncoder().encode("123"))
                .roles("ESTUDANTE")
                .build();
        UserDetails admin = User.builder()
                .username("administrador")
                .password(passwordEncoder().encode("123"))
                .roles("ADMINISTRADOR", "VISITANTE", "PROFESSOR", "ESTUDANTE")
                .build();

        return new InMemoryUserDetailsManager(visitante, professor, estudante, admin);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> {
                    requests
                            .requestMatchers("/").permitAll()
                            .requestMatchers("/visitante").hasRole("VISITANTE")
                            .requestMatchers("/professor").hasRole("PROFESSOR")
                            .requestMatchers("/estudante").hasRole("ESTUDANTE")
                            .requestMatchers("/administrador").hasRole("ADMINISTRADOR")
                            .anyRequest().authenticated();
                        }
                )
            .formLogin((form) -> form
                    .loginPage("/login")
                    .permitAll()
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/")
                    .usernameParameter("usuario")
                    .passwordParameter("senha")
            )
            .logout((logout) -> logout.permitAll());

        return http.build();
    }

}
