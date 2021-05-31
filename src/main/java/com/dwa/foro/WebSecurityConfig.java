package com.dwa.foro;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers(
					"/",
					"/css/**",
					"/js/**",
					"/usuario/**",
					"/usuario/validar"
					).permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/usuario/validar")
			.successForwardUrl("/usuario/validar")
			.permitAll()
			.and()
		.logout()
			.permitAll();
	}
}
