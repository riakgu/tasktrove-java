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
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import tasktrove.model.User;
import tasktrove.util.Database;

/**
 *
 * @author riakgu
 */
public class HomeController {
    
    private User user;
    
    public HomeController(User currentUser) {
        this.user = currentUser;
    }
    
    public int getUndoneTasks() {
        int count = 0;
        try {
            Connection connection = Database.getConnection(); // Ganti dengan metode koneksi database Anda
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM tasks WHERE user_id = ? AND status != 'DONE'");
            ps.setInt(1, user.getUser_id());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public int getTotalTasks() {
        int count = 0;
        try {
            Connection connection = Database.getConnection(); // Ganti dengan metode koneksi database Anda
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM tasks WHERE user_id = ?");
            ps.setInt(1, user.getUser_id());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public ResultSet getTasks() {
        LocalDate today = LocalDate.now();
        Date sqlToday = Date.valueOf(today);
        
        ResultSet rs = null;
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE user_id = ? AND deadline = ?");
            ps.setInt(1, user.getUser_id());
            ps.setDate(2, sqlToday);

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
