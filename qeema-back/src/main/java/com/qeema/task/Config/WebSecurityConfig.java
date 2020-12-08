package com.qeema.task.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;





@SuppressWarnings("deprecation")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	

	
	
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
	private AuthenticationEntryPoint authEntryPoint;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	
    	http.cors();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/Registration").permitAll()
                .antMatchers("/api/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/ws/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/api/Registration").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest()
                .authenticated().and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .httpBasic().authenticationEntryPoint(authEntryPoint);
                //.formLogin();
               

        /** Disabled for local testing */
        http.csrf().disable();
        
       

        /** This is solely required to support H2 console viewing in Spring MVC with Spring Security */
        http.headers()
                .frameOptions()
                .disable();
    	
    	
   
    }


	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}