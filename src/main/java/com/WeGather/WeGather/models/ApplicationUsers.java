package com.WeGather.WeGather.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public
class ApplicationUsers implements UserDetails {



    Users user;


// constructors

    public
    ApplicationUsers(User user) {
        this.user = user;
    }




    //getters & setters


    public
    Long getId() {
        return  user.getId();
    }




    // UserDetails override methods
    @Override
    public
    Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority simpleGrantedAuthorityUser = new SimpleGrantedAuthority(user.getAuthority());
        List<SimpleGrantedAuthority> userAuthorities = new ArrayList<SimpleGrantedAuthority>();

        userAuthorities.add(simpleGrantedAuthorityUser);

        return userAuthorities;
    }

    @Override
    public
    String getPassword() {

            return user.getPassword();
    }

    @Override
    public
    String getUsername() {

            return user.getUserName();
    }

    @Override
    public
    boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public
    boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public
    boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public
    boolean isEnabled() {
        return true;
    }
}
