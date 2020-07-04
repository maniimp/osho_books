package com.osho.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.osho.security.ApplicationUserRole.*;

@Configuration
public class AuthorizationAndSecurity extends WebSecurityConfigurerAdapter{
	 
 
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public AuthorizationAndSecurity(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
	/*@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passEncoder());
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","index","/css/*","/js/*").permitAll()
		.antMatchers("/users/**").hasRole(ADMIN.name())
		.antMatchers("/images/**").hasRole(ADMIN.name())
		.antMatchers("/shop/**").hasRole(CUSTOMER.name())
		.antMatchers("/gallery/**").hasRole(CUSTOMER.name())
		.antMatchers("/payment/**").hasRole(CUSTOMER.name())
		.antMatchers("/events/**").hasRole(CUSTOMER.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService()
	{
		
		UserDetails universalUser = User.builder()
				.username("admin")
				.password(passwordEncoder.encode("password"))
				.roles(ADMIN.name())
				.build();
		
		UserDetails customerUser = User.builder()
				.username("customer")
				.password(passwordEncoder.encode("password"))
				.roles(CUSTOMER.name())
				.build();
		
				
		return new InMemoryUserDetailsManager(
				universalUser,
				customerUser
				);		
	}
	
	@Bean
	public BCryptPasswordEncoder passEncoder(){
		return new BCryptPasswordEncoder();
	}
}