/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author riakgu
 */
public class Database {
    static final String DB_URL = "jdbc:mysql://localhost:3307/tasktrove_java";
    static final String DB_USER = "root";
    static final String DB_PASS = "root";
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    
    public Database() {
        
    }
    
    
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            statement = connection.createStatement();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,""+e.getMessage(), "Connection Error", JOptionPane.WARNING_MESSAGE);
        }
        return connection;
    }
    
}
