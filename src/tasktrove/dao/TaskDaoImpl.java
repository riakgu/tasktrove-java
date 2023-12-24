/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tasktrove.config.Database;
import tasktrove.model.Task;

/**
 *
 * @author riakgu
 */
public class TaskDaoImpl implements TaskDao {

    @Override
    public ResultSet getAll(int user_id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE user_id = ?");
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();          
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Task get(int task_id) {
        try {
            Task task = null;
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE task_id = ?");
            ps.setInt(1, task_id);
            ResultSet rs = ps.executeQuery();          
            while (rs != null && rs.next()) {
                task.setTask_id(rs.getInt("task_id"));
                task.setUser_id(rs.getInt("user_id"));
                task.setTask_name(rs.getString("task_name"));
                task.setDescription(rs.getString("description"));
                task.setStarted(rs.getDate("started"));
                task.setDeadline(rs.getDate("deadline"));
                task.setStatus(rs.getString("status"));
            }
            return task;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public int getUndone(int user_id) {
        int count = 0;
        try {
            Connection connection = Database.getConnection(); 
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM tasks WHERE user_id = ? AND status != 'DONE'");
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int getTotal(int user_id) {
        int count = 0;
        try {
            Connection connection = Database.getConnection(); 
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM tasks WHERE user_id = ?");
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    @Override
    public boolean save(Task task) {
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

    @Override
    public boolean update(Task task) {
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

    @Override
    public boolean delete(int task_id) {
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

    


}
