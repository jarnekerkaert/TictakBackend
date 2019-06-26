package com.hogent.tictak;

import com.hogent.tictak.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MongoUserService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public MongoUserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("user"));

        return buildUserForAuthentication(new User(user.getId(), user.getName(), user.getPassword()), authorities);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }
}
