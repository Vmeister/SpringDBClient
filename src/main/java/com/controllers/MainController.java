/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.hibernate.HibernateConnection;
import com.model.Person;
import com.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private HibernateConnection connection;
        
    @RequestMapping(value = "/people", method = RequestMethod.GET)
    List<Person> getEmployees() {
        return this.connection.listPersons();
        }
        
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<User> getUsers() {
        return this.connection.listUsers();
        }
    
    @RequestMapping(value = "/loginpage")
    ModelAndView showLoginPage(){
        return new ModelAndView("login");
    }
}