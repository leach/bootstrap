package com.anythy.authentication;

import com.anythy.userDetails.CustomUserDetails;
import com.anythy.userDetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        if(userName == null || "".equals(userName)){
            throw new BadCredentialsException("userName cannot be empty.");
        }
        String password = (String) authentication.getCredentials();
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(userName);
        if(userDetails == null){
            throw new BadCredentialsException("userName not found.");
        }
        if(!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("wrong password.");
        }
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
