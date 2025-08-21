package com.echoitsolution.first.service;

import com.echoitsolution.first.entities.Role;
import com.echoitsolution.first.entities.UserEntity;
import com.echoitsolution.first.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Called by Spring Security during authentication
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .disabled(!user.isEnabled())
                // .roles(...) will prefix roles with "ROLE_"
                .roles(user.getRoles().stream()
                        .map(Role::getName) // names like "USER","ADMIN"
                        .toArray(String[]::new))
                .build();
    }

}
