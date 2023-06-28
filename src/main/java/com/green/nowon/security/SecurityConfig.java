package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.antMatchers("/","/**").permitAll()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			
			).formLogin(form->
				form
					.loginPage("/sign/signin")
					.loginProcessingUrl("/login-Proc")
					.usernameParameter("id")
					.passwordParameter("password")
					.defaultSuccessUrl("/",true)
					.successHandler(mySuccessHandler())
					.permitAll());
		
		return http.build();
	}

	private AuthenticationSuccessHandler mySuccessHandler() {
		// TODO Auto-generated method stub
		return new MYAuthenticationSuccessHandler();
	}

}
