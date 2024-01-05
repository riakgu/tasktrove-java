package tasktrove.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Database {
    static final String DB_URL = "jdbc:mysql://103.59.160.21:3306/tasktrov_java";
    static final String DB_USER = "tasktrov_java";
    static final String DB_PASS = "tasktrov_java";
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
