/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ville
 */

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    
    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.model.User user = userRepository.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserrole());
        return authenticateUser(user, authorities);
    }
    
    private User authenticateUser(com.model.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
			user.getActivated(), true, true, true, authorities);
    }
    
    private List<GrantedAuthority> buildUserAuthority(String userrole) {
        List<GrantedAuthority> setAuths = new ArrayList<>();
        String userrole2 = "ROLE_" + userrole;
        setAuths.add(new SimpleGrantedAuthority(userrole2));
        return setAuths;
    }
    
}
