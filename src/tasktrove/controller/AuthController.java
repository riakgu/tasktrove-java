/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tasktrove.model.User;
import tasktrove.util.Database;

/**
 *
 * @author riakgu
 */
public class AuthController {
    public boolean authenticateUser(String username, String password) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String retrievedPassword = rs.getString("password"); // In real applications, this should be a hashed password
                return retrievedPassword.equals(password); // Change this line to use password hashing
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public User getUserDetails(String username) {
        User user = new User();
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Penanganan eksepsi
        }
        return user;
    }
}
