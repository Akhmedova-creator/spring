package ru.otus.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/list").authenticated()
                .and()
                .authorizeRequests().antMatchers("/api/books").authenticated()
                .and()
                .authorizeRequests().antMatchers("/save").authenticated()
                .and()
                .authorizeRequests().antMatchers("/saveBooks/**").authenticated()
                .and()
                .authorizeRequests().antMatchers("/authors").authenticated()
                .and()
                .authorizeRequests().antMatchers("/genres").authenticated()
                .and()
                .authorizeRequests().antMatchers("/delete/*").authenticated()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("password").roles("EDITOR")
                .and()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("someone").password("password").roles("SOMEONE");
    }
}
