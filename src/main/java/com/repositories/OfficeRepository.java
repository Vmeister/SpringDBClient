/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repositories;

import com.model.Employee;
import com.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ville
 */
public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
