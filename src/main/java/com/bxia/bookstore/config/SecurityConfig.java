package com.bxia.bookstore.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bxia.bookstore.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserMapper userMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("jack")
                .password(bCryptPasswordEncoder.encode("123456"))
                .roles("USER").build());
        return manager;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        return new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
                String username = Objects.toString(auth.getPrincipal());
                String password = Objects.toString(auth.getCredentials());
                com.bxia.bookstore.domain.User user = userMapper.selectOne(new LambdaQueryWrapper<>(
                        com.bxia.bookstore.domain.User.builder().username(username)
                                .password(password)
                                .build()));
                User principal = new User(username, "", List.of(new SimpleGrantedAuthority("ROLE_SYSTEM"), new SimpleGrantedAuthority("ROLE_USER")));
                if (null != user){
                    return new UsernamePasswordAuthenticationToken(principal, password,
                            List.of(new SimpleGrantedAuthority("ROLE_SYSTEM"), new SimpleGrantedAuthority("ROLE_USER")));
                }
                return null;
            }

            @Override
            public boolean supports(Class<?> aClass) {
                return aClass.equals(UsernamePasswordAuthenticationToken.class);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}