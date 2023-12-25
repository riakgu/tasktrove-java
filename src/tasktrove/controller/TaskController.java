package tasktrove.controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import tasktrove.dao.TaskDaoImpl;
import tasktrove.model.Task;

/**
 * TaskController mengelola operasi yang berkaitan dengan tugas, 
 * termasuk menampilkan, membuat, mengedit, dan menghapus tugas.
 */
public class TaskController {
    private TaskDaoImpl td = new TaskDaoImpl();
        
    /**
     * Mengisi model tabel dengan daftar tugas yang dimiliki oleh pengguna.
     * 
     * @param model Model tabel yang akan diisi dengan data tugas.
     * @param user_id ID pengguna untuk memfilter tugas yang relevan.
     */
    public void taskList(DefaultTableModel model, int user_id) {
        try {
            ResultSet rs = td.getAll(user_id);
            while (rs != null && rs.next()) {
                // Menambahkan data tugas ke model tabel
                model.addRow(new Object[]{
                    rs.getInt("task_id"),
                    rs.getString("task_name"),
                    rs.getString("description"),
                    rs.getDate("started"),
                    rs.getDate("deadline"),
                    rs.getString("status")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Membuat tugas baru dalam database.
     * 
     * @param task Objek Task yang akan disimpan.
     * @return true jika tugas berhasil dibuat, false jika gagal.
     */
    public boolean createTask(Task task) {
        return td.save(task);
    }
    
    /**
     * Memperbarui informasi tugas yang ada dalam database.
     * 
     * @param task Objek Task yang telah diperbarui.
     * @return true jika tugas berhasil diperbarui, false jika gagal.
     */
    public boolean editTask(Task task) {
        return td.update(task);
    }
    
    /**
     * Menghapus tugas dari database berdasarkan ID tugas.
     * 
     * @param task_id ID dari tugas yang akan dihapus.
     * @return true jika tugas berhasil dihapus, false jika gagal.
     */
    public boolean deleteTask(int task_id) {
        return td.delete(task_id);
    }
}
