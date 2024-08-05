package com.jwt.authentaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebsecurityConfig extends WebSecurityConfiguration {
	@Autowired
	UserDetailsService userDetailsService;

	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();

	}

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "MANAGER").requestMatchers(HttpMethod.PUT)
				.hasAnyRole("ADMIN", "MANAGER").requestMatchers(HttpMethod.DELETE).hasAnyRole("MANAGER")
				.requestMatchers(HttpMethod.GET, "/v1/cars").hasAnyRole("ADMIN", "MANAGER", "USER")

				.requestMatchers(HttpMethod.GET, "/v1/users").hasAnyRole("ADMIN", "MANAGER")
				.requestMatchers(HttpMethod.GET, "/v1/users/{userId}")
				.access("@userSecurity.hasUserId(authentication,#userId)");

		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();

		super.configure(http);

	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers("/h2-console/**");
	}

}
