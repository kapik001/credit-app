package com.kapusta.webapp.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class User implements UserDetails {

    private String login;
    private String password;
    private Collection<Role> roles;
    private UserPrivateData userPrivateData;
    private Collection<SimpleGrantedAuthority> grantedAuthorities;

    public User(String login, String password, UserPrivateData userPrivateData) {
        this.login = login;
        this.password = password;
        this.userPrivateData = userPrivateData;
        this.grantedAuthorities = new ArrayList<>();
    }

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserPrivateData getUserPrivateData() {
        return userPrivateData;
    }

    public void setUserPrivateData(UserPrivateData userPrivateData) {
        this.userPrivateData = userPrivateData;
    }
}
