package com.sha.springbootmicroservice3gateway.security;

import com.sha.springbootmicroservice3gateway.model.User;
import com.sha.springbootmicroservice3gateway.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        return new UserPrincipal(user.getUserId() ,user.getUserUserName() , user.getUserPassword());
    }
}
