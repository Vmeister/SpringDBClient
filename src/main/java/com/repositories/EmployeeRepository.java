/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repositories;

import com.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ville
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public Employee findById(Integer id);
}
