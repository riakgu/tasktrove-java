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
import tasktrove.dao.TaskDaoImpl;
import tasktrove.dao.UserDaoImpl;
import tasktrove.model.User;

/**
 *
 * @author riakgu
 */
public class SettingsController {
    
    private UserDaoImpl ud = new UserDaoImpl();
    
    public boolean settingsPassword(int user_id, String newPassword ) {
        User user = ud.getById(user_id);
        user.setPassword(newPassword);

        return ud.update(user);
    }
    
    public boolean settingsProfile(int user_id, String name, String username) {
        User user = ud.getById(user_id);
        user.setName(name);
        user.setUsername(username);

        return ud.update(user);
    }    
}
