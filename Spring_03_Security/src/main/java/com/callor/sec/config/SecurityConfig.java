package com.callor.sec.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        http.formLogin();
        /**
         * spring Security에서 form으로 데이터를 전송할 때
         * 보통 POST로 전송을 하는데
         * POST로 전송을 할 때는 반드시 _csrf.token 값을 데이터에 포함하여 전소을 해야한다.
         *
         * form을 만들 때, JSP, thymeleaf 등의 taglibs 등을 사용하면
         * 자동으로 _csrf.token을 form에 포함시키는 코드를 만들어준다
         *
         * 최근 spring security 정책이
         * https(Hyper Text Transfer protocol Sec)가 적용된 곳에서는
         * 정상적으로 _ csrf.token 을 form에 추가한다
         *
         * 그런데 http로 되어있는 곳에서는 정상적으로 추가하지 않는다
         * http로 테스트를 하는 경우는 아래 속성을 추가해 주어야 한다.
         */
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("callor")
                .password("{noop}1234")
                .roles("ADMIN");
    }
}
