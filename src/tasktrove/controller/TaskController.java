/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import tasktrove.model.User;
import tasktrove.config.Database;

/**
 *
 * @author riakgu
 */
public class TaskController {
    private User user;
    
    public TaskController(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
    public ResultSet getTasks() {
        ResultSet rs = null;
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE user_id = ?");
            ps.setInt(1, user.getUser_id());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public void loadTasksIntoTable(DefaultTableModel model) {
        try {
            ResultSet rs = getTasks();
            while (rs != null && rs.next()) {
                String taskName = rs.getString("task_name");
                String description = rs.getString("description");
                Date started = rs.getDate("started");
                Date deadline = rs.getDate("deadline");
                String status = rs.getString("status");

                model.addRow(new Object[]{taskName, description, started, deadline, status});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
