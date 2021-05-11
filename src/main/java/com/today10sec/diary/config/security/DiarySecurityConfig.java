package com.today10sec.diary.config.security;

import com.today10sec.diary.mvc.service.impl.DefaultCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class DiarySecurityConfig extends WebSecurityConfigurerAdapter {

    private DefaultCustomerService defaultCustomerService;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/diary","/diary/**", "/daily/**").hasRole("USER")
                .antMatchers("/", "/sample**", "/customer/login", "/customer/signUp"
                        , "/error/**").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                    .loginPage("/customer/login")
                    .defaultSuccessUrl("/diary/add")

                .and()
                .logout()
                    .logoutSuccessUrl("/customer/login")
                    .invalidateHttpSession(true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(defaultCustomerService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Autowired
    public void setDefaultCustomerService(DefaultCustomerService defaultCustomerService) {
        this.defaultCustomerService = defaultCustomerService;
    }
}
