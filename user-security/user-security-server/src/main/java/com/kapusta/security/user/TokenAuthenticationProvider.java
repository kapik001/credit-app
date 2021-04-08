package com.kapusta.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserAuthenticationService auth;

    @Override
    protected void additionalAuthenticationChecks(final UserDetails d, final UsernamePasswordAuthenticationToken auth) {
        // Nothing to do
    }

    @Override
    protected UserDetails retrieveUser(final String username, final UsernamePasswordAuthenticationToken authentication) {
        Object token = authentication.getCredentials();
        if (token instanceof String) {
            UserDetails user = auth.findByToken(String.valueOf(token));
            if (user != null) {
                return user;
            } else {
                throw new UsernameNotFoundException("User not found for token=" + token);
            }
        } else {
            throw new UsernameNotFoundException("Invalid token");
        }
    }
}