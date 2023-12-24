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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tasktrove.model.User;
import tasktrove.config.Database;
import tasktrove.dao.TaskDao;
import tasktrove.dao.TaskDaoImpl;
import tasktrove.model.Task;

/**
 *
 * @author riakgu
 */
public class TaskController {
    private TaskDaoImpl td = new TaskDaoImpl();
        
    public void taskList(DefaultTableModel model, int user_id) {
        try {
            ResultSet rs = td.getAll(user_id);
            while (rs != null && rs.next()) {
                int taskId = rs.getInt("task_id");
                String taskName = rs.getString("task_name");
                String description = rs.getString("description");
                Date started = rs.getDate("started");
                Date deadline = rs.getDate("deadline");
                String status = rs.getString("status");
                
                model.addRow(new Object[]{taskId, taskName, description, started, deadline, status});
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createTask(Task task) {
        return td.save(task);
    }
    
    public boolean editTask(Task task) {
        return td.update(task);
    }
    
    public boolean deleteTask(int task_id) {
        return td.delete(task_id);
    }
}
