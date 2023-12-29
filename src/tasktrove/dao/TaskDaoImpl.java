package tasktrove.dao;

import java.sql.*;
import tasktrove.config.Database;
import tasktrove.model.Task;

/**
 * Implementasi dari interface TaskDao yang menyediakan metode untuk melakukan operasi database
 * pada tabel tugas.
 */
public class TaskDaoImpl implements TaskDao {

    /**
     * Mengambil semua tugas dari database untuk pengguna tertentu.
     *
     * @param user_id ID pengguna yang tugasnya akan diambil.
     * @return ResultSet ResultSet yang berisi data tugas.
     */
    @Override
    public ResultSet getAll(int user_id) {
        try {
            Connection connection = Database.getConnection(); // Membuat koneksi database.
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE user_id = ?"); // Menyiapkan query SQL.
            ps.setInt(1, user_id); // Menetapkan parameter user_id.
            return ps.executeQuery(); // Menjalankan query dan mengembalikan hasilnya.
        } catch (SQLException e) {
            e.printStackTrace(); // Mencetak stack trace jika terjadi kesalahan.
        }
        return null;
    }

    /**
     * Mengambil satu tugas dari database berdasarkan ID tugas.
     *
     * @param task_id ID tugas yang akan diambil.
     * @return Task Objek Task yang diambil dari database.
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
                // Mengisi objek Task dengan data dari ResultSet.
                //task = new Task();
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
     * Menghitung jumlah tugas yang belum selesai berdasarkan ID pengguna.
     *
     * @param user_id ID pengguna.
     * @return int Jumlah tugas yang belum selesai.
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
                count = rs.getInt(1); // Mengambil jumlah dari query.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Menghitung jumlah total tugas berdasarkan ID pengguna.
     *
     * @param user_id ID pengguna.
     * @return int Jumlah total tugas.
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
                count = rs.getInt(1); // Mengambil jumlah dari query.
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
     * @return boolean Mengembalikan true jika penyimpanan berhasil, false jika gagal.
     */
    @Override
    public boolean save(Task task) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tasks (user_id, task_name, description, started, deadline, status) VALUES (?, ?, ?, ?, ?, ?)");
            // Menetapkan parameter untuk PreparedStatement.
            ps.setInt(1, task.getUser_id());
            ps.setString(2, task.getTask_name());
            ps.setString(3, task.getDescription());
            ps.setDate(4, task.getStarted());
            ps.setDate(5, task.getDeadline());
            ps.setString(6, task.getStatus());
            return ps.executeUpdate() > 0; // Menjalankan query dan memeriksa apakah ada baris yang terpengaruh.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Memperbarui tugas yang sudah ada di database.
     *
     * @param task Objek Task yang akan diperbarui.
     * @return boolean Mengembalikan true jika pembaruan berhasil, false jika gagal.
     */
    @Override
    public boolean update(Task task) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE tasks SET task_name = ?, description = ?, started = ?, deadline = ?, status = ? WHERE task_id = ?");
            // Menetapkan parameter untuk PreparedStatement.
            ps.setString(1, task.getTask_name());
            ps.setString(2, task.getDescription());
            ps.setDate(3, task.getStarted());
            ps.setDate(4, task.getDeadline());
            ps.setString(5, task.getStatus());
            ps.setInt(6, task.getTask_id());
            return ps.executeUpdate() > 0; // Menjalankan query dan memeriksa apakah ada baris yang terpengaruh.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Menghapus tugas dari database berdasarkan ID tugas.
     *
     * @param task_id ID tugas yang akan dihapus.
     * @return boolean Mengembalikan true jika penghapusan berhasil, false jika gagal.
     */
    @Override
    public boolean delete(int task_id) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM tasks WHERE task_id = ?");
            ps.setInt(1, task_id);
            return ps.executeUpdate() > 0; // Menjalankan query dan memeriksa apakah ada baris yang terpengaruh.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
