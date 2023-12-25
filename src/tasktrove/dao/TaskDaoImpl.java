package tasktrove.dao;

import java.sql.*;
import tasktrove.config.Database;
import tasktrove.model.Task;

/**
 * TaskDaoImpl menyediakan implementasi dari metode-metode untuk berinteraksi 
 * dengan tabel tugas dalam database.
 */
public class TaskDaoImpl implements TaskDao {

    /**
     * Mendapatkan semua tugas yang dimiliki oleh pengguna tertentu.
     * 
     * @param user_id ID pengguna untuk memfilter tugas.
     * @return ResultSet yang berisi tugas-tugas pengguna.
     */
    @Override
    public ResultSet getAll(int user_id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE user_id = ?");
            ps.setInt(1, user_id);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Mendapatkan tugas berdasarkan ID tugas.
     * 
     * @param task_id ID dari tugas yang diinginkan.
     * @return Objek Task yang diambil dari database.
     */
    @Override
    public Task get(int task_id) {
        try {
            Task task = null;
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE task_id = ?");
            ps.setInt(1, task_id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                //task = new Task(); // Instantiate the Task object
                // Setting task properties from ResultSet
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
    
    /**
     * Menghitung jumlah tugas yang belum selesai oleh pengguna.
     * 
     * @param user_id ID pengguna.
     * @return Jumlah tugas yang belum selesai.
     */
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

    /**
     * Menghitung total jumlah tugas yang dimiliki oleh pengguna.
     * 
     * @param user_id ID pengguna.
     * @return Total jumlah tugas.
     */
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
    
    /**
     * Menyimpan tugas baru ke dalam database.
     * 
     * @param task Objek Task yang akan disimpan.
     * @return true jika berhasil disimpan, false jika gagal.
     */
    @Override
    public boolean save(Task task) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tasks (user_id, task_name, description, started, deadline, status) VALUES (?, ?, ?, ?, ?, ?)");
            // Set parameters for the PreparedStatement
            ps.setInt(1, task.getUser_id());
            ps.setString(2, task.getTask_name());
            ps.setString(3, task.getDescription());
            ps.setDate(4, task.getStarted());
            ps.setDate(5, task.getDeadline());
            ps.setString(6, task.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Memperbarui tugas yang sudah ada di dalam database.
     * 
     * @param task Objek Task yang telah diperbarui.
     * @return true jika berhasil diperbarui, false jika gagal.
     */
    @Override
    public boolean update(Task task) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE tasks SET task_name = ?, description = ?, started = ?, deadline = ?, status = ? WHERE task_id = ?");
            // Set parameters for the PreparedStatement
            ps.setString(1, task.getTask_name());
            ps.setString(2, task.getDescription());
            ps.setDate(3, task.getStarted());
            ps.setDate(4, task.getDeadline());
            ps.setString(5, task.getStatus());
            ps.setInt(6, task.getTask_id());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }

    /**
     * Menghapus tugas dari database berdasarkan ID tugas.
     * 
     * @param task_id ID dari tugas yang akan dihapus.
     * @return true jika berhasil dihapus, false jika gagal.
     */
    @Override
    public boolean delete(int task_id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM tasks WHERE task_id = ?");
            ps.setInt(1, task_id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
