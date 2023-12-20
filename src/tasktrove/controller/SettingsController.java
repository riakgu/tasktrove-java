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
    
}
