package com.anythy.config;

import com.anythy.authentication.CustomLoginAuthenticationProvider;
import com.anythy.userDetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
@EnableConfigurationProperties(SecuritySettings.class)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomLoginAuthenticationProvider provider;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private SecuritySettings settings;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //路由策略和访问权限的简单配置
        http.authorizeRequests()
                .antMatchers("/statics/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .failureUrl(settings.getFailureUrl())
                .loginPage(settings.getLoginUrl()).permitAll()
                .defaultSuccessUrl(settings.getLoginSuccessUrl())
                .and()
                .logout().logoutUrl(settings.getLogoutUrl()).permitAll()
                .and()
                .exceptionHandling().accessDeniedPage(settings.getDeniedPage());

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
