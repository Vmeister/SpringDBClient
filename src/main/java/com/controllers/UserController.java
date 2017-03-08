/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.model.User;
import com.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    
    
    
        
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    String users(Model model) {
        List<User> users = this.userRepository.findAll();
        model.addAttribute("userList", users);
        return "users";
    }
    
    @RequestMapping(value = {"/", "/dbclient"}, method = RequestMethod.GET)
    ModelAndView dbclient(){
        return new ModelAndView("dbclient");
    }
    
    @RequestMapping(value = "/user/id={id}", method = RequestMethod.GET)
    String user(Model model, @PathVariable(value="id") String id) {
        if(id.equals("newuser")) {
            User newUser = new User();
            model.addAttribute("userById", newUser);
            return "user";
        }
        else {
            User user = this.userRepository.findById(Integer.parseInt(id));
            model.addAttribute("userById", user);
            return "user";
        }
    }
    
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    void saveUser(@ModelAttribute(value="userById") User user) {
        this.userRepository.saveAndFlush(user);
    }
    
    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    ModelAndView saveUserView() {
        return new ModelAndView("saveUser");
    }
    
    @RequestMapping(value = "/removeUser/id={id}", method = RequestMethod.POST)
    String removeUser(@PathVariable(value="id") String id) {
        User user = this.userRepository.findById(Integer.parseInt(id));
        this.userRepository.delete(user);
        return "userRemoved";
    }
    
    @RequestMapping(value = "/removeUser/id={id}", method = RequestMethod.GET)
    ModelAndView removeUserView() {
        return new ModelAndView("userRemoved");
    }
    
}