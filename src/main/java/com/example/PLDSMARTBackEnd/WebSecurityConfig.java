package com.example.PLDSMARTBackEnd;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/add/**").permitAll()
                .antMatchers("/user/authentication/**").permitAll()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .formLogin()
                    .loginProcessingUrl("/login")
                    .failureUrl("/login?error")
                .and()
                .logout().permitAll();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                    //.passwordEncoder(new BCryptPasswordEncoder())
                    .passwordAttribute("userPassword");
    }

}
