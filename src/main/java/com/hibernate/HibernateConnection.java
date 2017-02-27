package com.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.model.Person;
import com.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ville
 */
@Repository
public class HibernateConnection {
    @Autowired
    private static SessionFactory factory;
    User loggedUser;
    
      /**
     * Adds a new Person object to database
     * @param person a new person
     * @return ID of the added person
     */
    public Integer addPerson(Person person) {
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        Integer personID = null;
        try{
            tx = session.beginTransaction();
            personID = (Integer) session.save(person); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        return personID;
   }
    
     /**
     * Creates an ArrayList of all the persons in database
     * @return an ArrayList of persons
     */
    public ArrayList listPersons( ) {
        ArrayList<Person> persons = new ArrayList<>();
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Person").list(); 
            for (Iterator iterator = 
                employees.iterator(); iterator.hasNext();){
                    Person person = (Person) iterator.next(); 
                    if(!persons.contains(person))
                        persons.add(person);
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        return persons;
    }
    
    /**
     * Updates the data of a single person
     * @param person the person whose data is to be updated
     */
    public void updatePerson(Person person){
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //Person person2 = (Person)session.get(Person.class, person.getId());
            session.update(person); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
   }
    
        /**
     * Deletes a person's data from database
     * @param person person to be deleted
     */
    public void deletePerson(Person person){
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(person); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
    }
    
    /**
     * Adds a new user account to databse
     * @param user new user account
     * @return user ID
     */
    public Integer addUser(User user) {
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        Integer userID = null;
        try{
            tx = session.beginTransaction();
            userID = (Integer) session.save(user); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        return userID;
    }
    
    /**
     * Lists all the user accounts in the database
     * @return an ArrayList of user accounts
     */
    public ArrayList listUsers( ) {
        ArrayList<User> users = new ArrayList<>();
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List users2 = session.createQuery("FROM User").list(); 
            for (Iterator iterator = 
                            users2.iterator(); iterator.hasNext();){
                User user = (User) iterator.next(); 
                users.add(user);
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        return users;
    }

    /**
     * Updates an user account's login information
     * @param user user account to be updated
     */
    public void updateUser(User user){
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(user); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
    }

    /**
     * Deletes an user account from database
     * @param user user account to be deleted
     */
    public void deleteUser(User user){
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(user); 
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
    }
    
     /**
     * Log in procedure for a database connection
     * @param username username
     * @param password password
     * @return user account during successful login, null if fails
     */
    public User login(String username, String password) {
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        User user = null;
        try{
            tx = session.beginTransaction();
            List users = session.createQuery("FROM User").list(); 
            for (Iterator iterator = 
                users.iterator(); iterator.hasNext();){
                    User user2 = (User) iterator.next(); 
                    if(user2.getUsername().equals(username) && user2.getPassword().equals(password))
                        user = user2;
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        loggedUser = user;
        return user;
    }
    
    /**
     * Returns the logged user account
     * @return logged user
     */
    public User loggedUser() {
        return loggedUser;
        
    }
    
    public User findByUserName(String username) {
        Session session = factory.getCurrentSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM User").list(); 
            for (Iterator iterator = 
                users.iterator(); iterator.hasNext();){
                    User user2 = (User) iterator.next(); 
                    if(user2.getUsername().equals(username))
                        user = user2;
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }
        user = user;
        return user;
    }

    public void closeConnection() {
        factory.getCurrentSession().close();
        factory.close();
    }
}
