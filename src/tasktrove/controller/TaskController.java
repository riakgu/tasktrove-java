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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tasktrove.model.User;
import tasktrove.config.Database;
import tasktrove.model.Task;

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
    
    public boolean saveTask(Task task) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tasks (user_id, task_name, description, started, deadline, status) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, task.getUser_id());
            ps.setString(2, task.getTask_name());
            ps.setString(3, task.getDescription());
            ps.setDate(4, task.getStarted());
            ps.setDate(5, task.getDeadline());
            ps.setString(6, task.getStatus());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateTask(Task task) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE tasks SET task_name = ?, description = ?, started = ?, deadline = ?, status = ? WHERE task_id = ?");
            ps.setString(1, task.getTask_name());
            ps.setString(2, task.getDescription());
            ps.setDate(3, task.getStarted());
            ps.setDate(4, task.getDeadline());
            ps.setString(5, task.getStatus());
            ps.setInt(6, task.getTask_id());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    public boolean deleteTask(int task_id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM tasks WHERE task_id = ?");
            ps.setInt(1, task_id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
                int taskId = rs.getInt("task_id");
                String taskName = rs.getString("task_name");
                String description = rs.getString("description");
                Date started = rs.getDate("started");
                Date deadline = rs.getDate("deadline");
                String status = rs.getString("status");

                model.addRow(new Object[]{taskId, taskName, description, started, deadline, status});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
