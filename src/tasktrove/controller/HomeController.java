package tasktrove.controller;

import java.sql.*;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import tasktrove.dao.TaskDaoImpl;

/**
 * Kelas HomeController yang bertugas mengelola tampilan dan logika utama
 * dari aplikasi terkait tugas dan deadline.
 */
public class HomeController {
    
    private TaskDaoImpl td = new TaskDaoImpl(); // Membuat instance TaskDaoImpl untuk interaksi database.
    
    /**
     * Menampilkan tugas yang memiliki deadline hari ini dalam tabel.
     *
     * @param model Model tabel yang akan diisi dengan data tugas.
     * @param user_id ID pengguna untuk memfilter tugas.
     */
    public void deadlineToday(DefaultTableModel model, int user_id) {
        LocalDate today = LocalDate.now(); // Mendapatkan tanggal hari ini.
        Date sqlToday = Date.valueOf(today); // Mengonversi LocalDate ke java.sql.Date.
        
        try {
            ResultSet rs = td.getAll(user_id); // Mendapatkan semua tugas dari basis data untuk pengguna tertentu.
            while (rs != null && rs.next()) {
                // Jika deadline tugas sama dengan hari ini, tambahkan ke model tabel.
                if (rs.getDate("deadline").equals(sqlToday)) {
                    model.addRow(new Object[]{
                        rs.getInt("task_id"),       // ID Tugas
                        rs.getString("task_name"),  // Nama Tugas
                        rs.getString("description"),// Deskripsi Tugas
                        rs.getDate("started"),      // Tanggal Mulai
                        rs.getDate("deadline"),     // Tanggal Deadline
                        rs.getString("status")      // Status Tugas
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Mencetak error jika terjadi SQLException.
        }
    }

    /**
     * Menghitung jumlah tugas yang belum selesai untuk pengguna tertentu.
     *
     * @param user_id ID pengguna.
     * @return int Jumlah tugas yang belum selesai.
     */
    public int getUndoneTasks(int user_id) {
        return td.getUndone(user_id); // Memanggil metode getUndone dari TaskDaoImpl.
    }
    
    /**
     * Menghitung jumlah total tugas untuk pengguna tertentu.
     *
     * @param user_id ID pengguna.
     * @return int Jumlah total tugas.
     */
    public int getTotalTasks(int user_id) {
        return td.getTotal(user_id); // Memanggil metode getTotal dari TaskDaoImpl.
    }
}
