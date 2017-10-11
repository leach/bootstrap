package com.anythy.config;

import com.anythy.authentication.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Leach on 0019 2017/9/19.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${securityConfig.defaultUrl.failureUrl}")
    private String failureUrl;
    @Value("${securityConfig.defaultUrl.loginUrl}")
    private String loginUrl;
    @Value("${securityConfig.defaultUrl.successUrl}")
    private String successUrl;

    @Autowired
    private CustomAuthenticationProvider provider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //路由策略和访问权限的简单配置
        http.authorizeRequests()
                .antMatchers("/statics/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .failureUrl(failureUrl)
                .loginPage(loginUrl).permitAll()
                .defaultSuccessUrl(successUrl)
                .and()
                .logout().permitAll();

        super.configure(http);
    }

    /**
     * 配置内存用户
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }
}
