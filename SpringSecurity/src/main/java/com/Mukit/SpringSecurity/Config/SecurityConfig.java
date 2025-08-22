package com.Mukit.SpringSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
   private JwtFilter jwtFilter;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable()); // disable CSRF for simplicity

	    http.authorizeHttpRequests(auth -> auth
	        .requestMatchers("/register", "/login").permitAll() // allow these without login
	        .anyRequest().authenticated() // all other requests need authentication
	    );

	    http.formLogin(form -> form.disable()); // disable default login form
	    http.httpBasic(httpBasic -> httpBasic.disable()); // disable HTTP Basic
        http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	    return http.build();
	}



	/*
	 * @Bean public UserDetailsService userDetailsService() { UserDetails user1 =
	 * User.withDefaultPasswordEncoder().username("Mukit").password("@mu1").roles(
	 * "User").build(); UserDetails user2 =
	 * User.withDefaultPasswordEncoder().username("Mukit1").password("@mu11").roles(
	 * "User") .build(); return new InMemoryUserDetailsManager(user1, user2); }
	 */

	@Bean
	public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
		
	}
}