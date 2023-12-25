package tasktrove.controller;

import java.sql.*;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import tasktrove.dao.TaskDaoImpl;

/**
 * HomeController mengelola tampilan dan pemrosesan data terkait tugas dalam aplikasi.
 * Kelas ini berinteraksi dengan TaskDaoImpl untuk mengakses dan memanipulasi data tugas.
 */
public class HomeController {
    
    private TaskDaoImpl td = new TaskDaoImpl();
    
    /**
     * Menampilkan tugas yang memiliki tenggat waktu hari ini dalam model tabel.
     * 
     * @param model Model tabel yang digunakan untuk menampilkan data.
     * @param user_id ID pengguna untuk memfilter tugas yang relevan.
     */
    public void deadlineToday(DefaultTableModel model, int user_id) {
        LocalDate today = LocalDate.now();
        Date sqlToday = Date.valueOf(today);
        try {
            ResultSet rs = td.getAll(user_id);
            while (rs != null && rs.next()) {
                // Memeriksa apakah tenggat tugas sama dengan hari ini
                if (rs.getDate("deadline").equals(sqlToday)) {
                    // Menambahkan baris ke model tabel dengan data tugas
                    model.addRow(new Object[]{
                        rs.getInt("task_id"),
                        rs.getString("task_name"),
                        rs.getString("description"),
                        rs.getDate("started"),
                        rs.getDate("deadline"),
                        rs.getString("status")
                    });
                }
            }
        } catch (SQLException e) {
            // Menangani eksepsi SQL
            e.printStackTrace();
        }
    }
    
    /**
     * Mendapatkan jumlah tugas yang belum selesai oleh pengguna.
     * 
     * @param user_id ID pengguna.
     * @return Jumlah tugas yang belum selesai.
     */
    public int getUndoneTasks(int user_id) {
        return td.getUndone(user_id);
    }
    
    /**
     * Mendapatkan total jumlah tugas yang dimiliki oleh pengguna.
     * 
     * @param user_id ID pengguna.
     * @return Total jumlah tugas.
     */
    public int getTotalTasks(int user_id) {
        return td.getTotal(user_id);
    }
}
