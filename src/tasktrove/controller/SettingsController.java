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
import javax.swing.JOptionPane;
import tasktrove.config.Database;
import tasktrove.model.User;

/**
 *
 * @author riakgu
 */
public class SettingsController {

    private User user;
    
    public SettingsController(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
    public boolean settingsPassword(int user_id, String newPassword ) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET password = ? WHERE user_id = ?");
            ps.setString(1, newPassword);
            ps.setInt(2, user_id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean settingsProfile(int user_id, String name, String username) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET name = ?, username = ? WHERE user_id = ?");
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setInt(3, user_id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }    
}
