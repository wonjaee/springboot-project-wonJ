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
	//1.비동기로 게시글 불러오는도중 403 에러가나옴 
	//2.admin 계정으로 로그인을했는데 admin게시글로 이동이안됨 
	//3. aws 버킷 사용 설정방법
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.antMatchers("/","/**").permitAll()
				.antMatchers("/css/**","/js/**").permitAll()
				.antMatchers("/admin/**").permitAll()//.hasRole("ADMIN")
				.anyRequest().authenticated()
			
			).formLogin(form->
				form
					.loginPage("/sign/signin")
					.loginProcessingUrl("/login-Proc")
					.usernameParameter("id")
					.passwordParameter("password")
					.defaultSuccessUrl("/",true)
					.successHandler(mySuccessHandler())
					.permitAll()
					
			).logout(logout->logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
					)
			
			;
		
		return http.build();
	}

	private AuthenticationSuccessHandler mySuccessHandler() {
		// TODO Auto-generated method stub
		return new MYAuthenticationSuccessHandler();
	}

}
