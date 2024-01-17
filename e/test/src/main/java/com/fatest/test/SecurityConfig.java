package com.fatest.test;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/* */
@Configuration
@EnableWebSecurity
 
public class SecurityConfig {
   
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	  http
      .authorizeHttpRequests(authorize ->
        authorize.requestMatchers("/login").permitAll()
        .anyRequest().authenticated())
      .formLogin(form -> 
      form.defaultSuccessUrl("/")
      
      );
      return http.build();
    //   .authorizeRequests()
	//       .requestMatchers("/login").permitAll()
	//       .requestMatchers("/**").authenticated()
	//       .and()
	//       .formLogin()
    //       .defaultSuccessUrl("/success")
    //       .failureUrl("/error")
    //       .permitAll();
	//       return http.build();
	}

    @Bean
    public UserDetailsService userDetailsService() {


        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("password"))
            .roles("USER", "ADMIN")
            .build();

        UserDetails user = User.builder()
        .username("user")
        .password(passwordEncoder().encode("password"))
        .roles("USER")
        .build();
        return new InMemoryUserDetailsManager(admin,user);

   }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();    
    }

}
