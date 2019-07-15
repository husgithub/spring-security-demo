package com.example.demo.service;

import com.example.demo.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserService myUserService;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        MyUser myUser = myUserService.getUserWithName(loginName);
        if (ObjectUtils.isEmpty(myUser)) {
            throw new UsernameNotFoundException("未知用户！");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(myUser.getRole()));
        User userDetail = new User(loginName, myUser.getPassword(), authorities);
        return userDetail;
    }
}
