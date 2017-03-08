/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.model.Employee;
import com.model.User;
import com.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ville
 */

@Controller
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
        
        
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    String users(Model model) {
        List<Employee> employees = this.employeeRepository.findAll();
        model.addAttribute("employeeList", employees);
        return "employees";
    }
    
    @RequestMapping(value = "/employee/id={id}", method = RequestMethod.GET)
    String user(Model model, @PathVariable(value="id") String id) {
        if(id.equals("newemployee")) {
            Employee employee = new Employee();
            model.addAttribute("employee", employee);
            return "employee";
        }
        else {
            Employee employee = this.employeeRepository.findById(Integer.parseInt(id));
            model.addAttribute("employee", employee);
            return "employee";
        }
    }
    
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    void saveUser(@ModelAttribute(value="employee") Employee employee) {
        System.out.println(employee.toString());
        this.employeeRepository.save(employee);
    }
    
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.GET)
    ModelAndView saveEmployeeView() {
        return new ModelAndView("saveEmployee");
    }
    
    @RequestMapping(value = "/removeEmployee/id={id}", method = RequestMethod.POST)
    String removeUser(@PathVariable(value="id") String id) {
        Integer id2 = Integer.parseInt(id);
        Employee employee = this.employeeRepository.findById(id2);
        this.employeeRepository.delete(employee);
        return "employeeRemoved";
    }
    
    @RequestMapping(value = "/removeEmployee/id={id}", method = RequestMethod.GET)
    ModelAndView removeUserView() {
        return new ModelAndView("employeeRemoved");
    }
    
}
