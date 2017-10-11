package com.anythy.userDetails;

import com.anythy.entity.User;
import com.anythy.entity.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by Leach on 0010 2017/10/10.
 */
public class CustomUserDetails extends User implements UserDetails {

    private List<UserRole> roles;

    public CustomUserDetails(User user, List<UserRole> roles){
        super(user);
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles == null || roles.size() < 1){
            return AuthorityUtils.NO_AUTHORITIES;
        }
        StringBuilder commaBuilder = new StringBuilder();
        roles.forEach(userRole -> {
            commaBuilder.append(userRole.getRoleName()).append(",");
        });
        return AuthorityUtils.commaSeparatedStringToAuthorityList(commaBuilder.toString());
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public String getPassword(){
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
