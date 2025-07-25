package com.example.webfluxdemo.securuty;

/*
https://hyperskill.org/learn/step/31611
https://hyperskill.org/learn/step/27488
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http){
        return http
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/user").hasAnyRole("USER", "ADMIN")
                .pathMatchers("/admin").hasRole("ADMIN")
                .pathMatchers(HttpMethod.POST, "/public").hasAuthority("WRITE")
                .pathMatchers("/secured").authenticated()
                .pathMatchers("/actuator/**").hasAuthority("MONITORING")
                .pathMatchers(HttpMethod.GET, "/**").permitAll()
                .anyExchange().denyAll()
            )
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
//            .formLogin(ServerHttpSecurity.FormLoginSpec::disable)     // для API запрещаем форму логина
            .csrf(ServerHttpSecurity.CsrfSpec::disable)     // для API запрещаем CSRF
            .build();
    }

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        final UserDetails u1 = User.builder()
            .username("user1")
            .password(passEncoder().encode("pwd"))
            .authorities("WRITE")
            .build();

        final UserDetails u2 = User.builder()
            .username("user2")
            .password(passEncoder().encode("pwd"))
            .roles("USER")
            .build();

        final UserDetails u3 = User.withDefaultPasswordEncoder()
            .username("user3")
            .password("pwd")
            .authorities("ROLE_ADMIN", "WRITE", "MONITORING")
            .build();

        return new MapReactiveUserDetailsService(u1, u2, u3);
    }

    @Bean
    public PasswordEncoder passEncoder() {
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
