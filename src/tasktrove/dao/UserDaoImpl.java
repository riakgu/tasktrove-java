package tasktrove.dao;

import java.sql.*;
import tasktrove.config.Database;
import tasktrove.model.User;

/**
 * Implementasi dari interface UserDao yang menyediakan metode untuk operasi database
 * pada tabel pengguna.
 */
public class UserDaoImpl implements UserDao {

    /**
     * Mendapatkan pengguna berdasarkan username.
     *
     * @param username Username pengguna yang akan dicari.
     * @return User Objek User yang diambil dari database, atau null jika tidak ditemukan.
     */
    @Override
    public User getByUsername(String username) {
        try {
            User user = new User();
            Connection connection = Database.getConnection(); // Membuat koneksi ke database.
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?"); // Menyiapkan query SQL.
            ps.setString(1, username); // Menetapkan username ke PreparedStatement.
            ResultSet rs = ps.executeQuery(); // Menjalankan query.
            if (rs.next()) {
                // Mengisi objek User dengan data dari ResultSet.
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace(); // Mencetak stack trace jika terjadi kesalahan.
        }
        return null;
    }

    /**
     * Mendapatkan pengguna berdasarkan ID.
     *
     * @param user_id ID pengguna yang akan dicari.
     * @return User Objek User yang diambil dari database, atau null jika tidak ditemukan.
     */
    @Override
    public User getById(int user_id) {
        try {
            User user = new User();
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            ps.setInt(1, user_id); // Menetapkan user_id ke PreparedStatement.
            ResultSet rs = ps.executeQuery(); // Menjalankan query.
            if (rs.next()) {
                // Mengisi objek User dengan data dari ResultSet.
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Menyimpan data pengguna baru ke dalam database.
     *
     * @param user Objek User yang akan disimpan.
     * @return boolean Mengembalikan true jika penyimpanan berhasil, false jika gagal.
     */
    @Override
    public boolean save(User user) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (name, username, password) VALUES (?, ?, ?)");
            // Menetapkan data pengguna ke PreparedStatement.
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            return ps.executeUpdate() > 0; // Menjalankan query dan memeriksa apakah ada baris yang terpengaruh.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Memperbarui data pengguna yang sudah ada di database.
     *
     * @param user Objek User yang akan diperbarui.
     * @return boolean Mengembalikan true jika pembaruan berhasil, false jika gagal.
     */
    @Override
    public boolean update(User user) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET name = ?, username = ?, password = ? WHERE user_id = ?");
            // Menetapkan data pengguna yang diperbarui ke PreparedStatement.
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getUser_id());
            return ps.executeUpdate() > 0; // Menjalankan query dan memeriksa apakah ada baris yang terpengaruh.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Menghapus pengguna dari database berdasarkan ID.
     *
     * @param user_id ID pengguna yang akan dihapus.
     */
    @Override
    public void delete(int user_id) {
        // Metode ini tidak diimplementasikan dalam contoh ini.
    }

}
