package io.opeleh.bulkpay.model;

import java.util.Arrays;
import java.util.Collection;
//import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsersDetails implements UserDetails {

   
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private boolean isEnabled;
    //private List <GrantedAuthority> authority;

    public UsersDetails() {
    }

    public UsersDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isEnabled = user.getIsEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return isEnabled;
    }

    

}