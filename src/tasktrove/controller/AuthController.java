/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.controller;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import tasktrove.model.User;
import tasktrove.config.Database;
import tasktrove.dao.UserDaoImpl;

/**
 *
 * @author riakgu
 */
public class AuthController {
    
    private UserDaoImpl ud = new UserDaoImpl();
    
    public boolean login(String username, String password) {
        User user = ud.getByUsername(username);
        
        return user.getPassword().equals(password);
    }
    
    public boolean register(String name, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        
        return ud.save(user);
    }

    public User getUserDetails(String username) {
        return ud.getByUsername(username);
    }
    
    public boolean isUserExists(String username) {
        User user = ud.getByUsername(username);
        
        return user != null;
    }
}
