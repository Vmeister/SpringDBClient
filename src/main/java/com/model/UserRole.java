/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Ville
 */
public class UserRole {

    private User user;
    private int ID;
    private String userrole;
    
    public UserRole(String userrole) {
        this.userrole = userrole;
    }
    
    public String getUserRole() {
        return userrole;
    }
    
    public void setUserRole(String userrole) {
        this.userrole = userrole;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
