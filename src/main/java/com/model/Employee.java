/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ville
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    
    @Column(nullable = false, length = 30)
    String firstname;
    
    @Column(nullable = false, length = 30)
    String lastname;
    
    @Column(nullable = false, length = 50)
    String address;
    
    @Column(nullable = false, length = 30)
    String phonenumber;
    
    @Column(nullable = false, length = 30)
    String email;
    
    Integer office_id;

    public Employee(String firstname, String lastname, String address,
            String phonenumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public Employee() {
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getOffice_id() {
        return office_id;
    }
    
    public void setOffice_id(Integer office_id) {
        this.office_id = office_id;
    }
    
    @Override
    public String toString() {
        return id + " " + firstname + " " + lastname + " " + address + " " + phonenumber + " " + email;
    }
    
    
}
