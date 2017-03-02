/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.User;
import java.util.List;

/**
 *
 * @author Ville
 */
public interface UserService {
    public User findByUsername(String username);
    public List<User> findAll();
    public void saveUser(User user);
    
}
