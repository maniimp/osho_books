package com.osho.security;

import static com.osho.security.ApplicationUserRole.ADMIN;
import static com.osho.security.ApplicationUserRole.CUSTOMER;

import javax.servlet.http.Cookie;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter.Directive;

@Configuration
public class AuthorizationAndSecurity extends WebSecurityConfigurerAdapter{
	 
 
	private final PasswordEncoder passwordEncoder;
	
	private static final Log LOG = LogFactory.getLog(AuthorizationAndSecurity.class.getSimpleName());
	
	@Autowired
	public AuthorizationAndSecurity(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		LOG.info("AuthorizationAndSecurity :"+passwordEncoder.matches("password", "$2a$10$hvnZXAj6B8UoQN/QNXxCJOEN1mhy2hlA.9cATtrQ73xRP1/N50ate"));
	}
	
	 /*private static final ClearSiteDataHeaderWriter.Directive[] SOURCE = 
	      {Directive.CACHE, Directive.COOKIES, Directive.STORAGE, Directive.EXECUTION_CONTEXTS};*/
	
	
	/*@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passEncoder());
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		LOG.info("TEST--configure:");
		http
		.csrf().disable()
		.authorizeRequests()
		 .antMatchers("/","index","/css/*","/js/*").permitAll()
		.antMatchers("/users/**").hasRole(ADMIN.name())
		//.antMatchers("/images/**").hasRole(ADMIN.name())
		//.antMatchers("/v1/**").hasRole(CUSTOMER.name())
		.antMatchers("/gallery/**").hasRole(CUSTOMER.name())
		.antMatchers("/payment/**").hasRole(CUSTOMER.name())
		.antMatchers("/events/**").hasRole(CUSTOMER.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		/*http
        .logout(logout -> logout
          .logoutUrl("/cookies/cookielogout")
          .addLogoutHandler((request, response, auth) -> {
              for (Cookie cookie : request.getCookies()) {
                  String cookieName = cookie.getName();
                  Cookie cookieToDelete = new Cookie(cookieName, null);
                  cookieToDelete.setMaxAge(0);
                  response.addCookie(cookieToDelete);
              }
          })
        );*/
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("user").password("{noop}password").roles("USER")
		//.withUser("user").password(passwordEncoder.encode("password")).roles("USER")
		.and()
		//.withUser("admin").password(passwordEncoder.encode("password")).roles("ADMIN");
		.withUser("admin").password("{noop}password").roles("ADMIN");
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService()
	{
		
		UserDetails universalUser = User.builder()
				.username("admin")
				.password("password")
				.roles(ADMIN.name())
				.build();
		
		UserDetails customerUser = User.builder()
				.username("customer")
				.password("password")
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