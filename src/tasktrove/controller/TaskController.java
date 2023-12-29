package tasktrove.controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import tasktrove.dao.TaskDaoImpl;
import tasktrove.model.Task;
import tasktrove.model.User;

/**
 * Kelas TaskController yang bertanggung jawab untuk mengelola operasi terkait tugas,
 * termasuk pembuatan, pembaruan, penghapusan, dan penampilan daftar tugas.
 */
public class TaskController {
    private TaskDaoImpl td = new TaskDaoImpl(); // Membuat instance dari TaskDaoImpl untuk interaksi dengan database.

    /**
     * Mengisi model tabel dengan daftar tugas berdasarkan user_id.
     * 
     * @param model Model tabel untuk menampilkan data tugas.
     * @param user_id ID pengguna untuk menentukan tugas yang ditampilkan.
     */
    public void taskList(DefaultTableModel model, int user_id) {
        try {
            ResultSet rs = td.getAll(user_id); // Mendapatkan semua tugas dari database untuk pengguna tertentu.
            while (rs != null && rs.next()) {
                // Menambahkan data tugas ke model tabel.
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
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex); // Mencatat error jika terjadi SQLException.
        }
    }
    
    /**
     * Membuat tugas baru di dalam database.
     * 
     * @param task Objek Task yang akan disimpan.
     * @return boolean Mengembalikan true jika pembuatan tugas berhasil, false jika gagal.
     */
    public boolean createTask(Task task) {
        return td.save(task); // Menyimpan tugas ke dalam database.
    }
    
    /**
     * Mengedit tugas yang sudah ada di dalam database.
     * 
     * @param task Objek Task yang sudah dimodifikasi untuk diupdate.
     * @return boolean Mengembalikan true jika pembaruan berhasil, false jika gagal.
     */
    public boolean editTask(Task task) {
        return td.update(task); // Memperbarui tugas di dalam database.
    }
    
    /**
     * Menghapus tugas dari database berdasarkan task_id.
     * 
     * @param task_id ID dari tugas yang akan dihapus.
     * @return boolean Mengembalikan true jika penghapusan berhasil, false jika gagal.
     */
    public boolean deleteTask(int task_id) {
        return td.delete(task_id); // Menghapus tugas dari database.
    }
    
    /**
     * Mendapatkan detail tugas berdasarkan task_id.
     * 
     * @param task_id ID tugas.
     * @return Task Mengembalikan objek Tssk yang berisi detail tugas.
     */
    public Task getTaskDetails(int task_id) {
        return td.get(task_id); // Mengembalikan detail tugas dari database.
    }
}
