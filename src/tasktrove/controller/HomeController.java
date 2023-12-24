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
import tasktrove.config.Database;
import tasktrove.dao.TaskDaoImpl;

/**
 *
 * @author riakgu
 */
public class HomeController {
    
    private TaskDaoImpl td = new TaskDaoImpl();
    
    public void deadlineToday(DefaultTableModel model, int user_id) {
        LocalDate today = LocalDate.now();
        Date sqlToday = Date.valueOf(today);
        try {
            ResultSet rs = td.getAll(user_id);
            while (rs != null && rs.next()) {
                if (rs.getDate("deadline").equals(sqlToday)) {
                    int taskId = rs.getInt("task_id");
                    String taskName = rs.getString("task_name");
                    String description = rs.getString("description");
                    Date started = rs.getDate("started");
                    Date deadline = rs.getDate("deadline");
                    String status = rs.getString("status");

                    model.addRow(new Object[]{taskId, taskName, description, started, deadline, status});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getUndoneTasks(int user_id) {
        return td.getUndone(user_id);
    }
    
    public int getTotalTasks(int user_id) {
        return td.getTotal(user_id);
    }
}
