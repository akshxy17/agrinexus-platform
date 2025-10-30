package com.example.Farmer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Farmer.entity.User;
import com.example.Farmer.entity.UserPrincipal;
import com.example.Farmer.repository.UserRepository;


@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository repo;

    @Autowired
    public MyUserDetailService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found "+ username);
        }
        return new UserPrincipal(user);
    }

}
