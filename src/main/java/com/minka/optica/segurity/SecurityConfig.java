package com.minka.optica.segurity;

import com.minka.optica.services.users.UsersServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableMethodSecurity // Activa el uso de anotaciones como @PreAuthorize
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/public/**")).permitAll() // Especificamos AntPathRequestMatcher
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/**")).authenticated()   // Especificamos AntPathRequestMatcher para rutas autenticadas
                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pacientes")).authenticated()

                )
                .httpBasic(httpBasicConfigurer -> {}) // Nueva forma de habilitar autenticación básica
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationManager(authenticationManager); // Usamos AuthenticationManager directamente

        return http.build();
    }

    // Bean para cifrar contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Registrar el proveedor de autenticación personalizado
    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider(UsersServiceImp userDetailsService, PasswordEncoder passwordEncoder) {
        return new CustomAuthenticationProvider(userDetailsService, passwordEncoder);
    }

    // Configuración explícita del AuthenticationManager con CustomAuthenticationProvider
    @Bean
    public AuthenticationManager authenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        return new ProviderManager(customAuthenticationProvider);
    }

    // Configuración de CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3800")); // URL de tu frontend
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}



