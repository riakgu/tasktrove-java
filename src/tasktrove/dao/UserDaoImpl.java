package tasktrove.dao;

import java.sql.*;
import tasktrove.config.Database;
import tasktrove.model.User;

/**
 * UserDaoImpl menyediakan implementasi dari metode-metode untuk berinteraksi 
 * dengan tabel pengguna dalam database.
 */
public class UserDaoImpl implements UserDao {

    /**
     * Mendapatkan pengguna dari database berdasarkan nama pengguna.
     * 
     * @param username Nama pengguna yang dicari.
     * @return Objek User yang ditemukan atau null jika tidak ada.
     */
    @Override
    public User getByUsername(String username) {
        try {
            User user = new User();
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
     * Mendapatkan pengguna dari database berdasarkan ID pengguna.
     * 
     * @param user_id ID dari pengguna yang dicari.
     * @return Objek User yang ditemukan atau null jika tidak ada.
     */
    @Override
    public User getById(int user_id) {
        try {
            User user = new User();
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
     * Menyimpan pengguna baru ke dalam database.
     * 
     * @param user Objek User yang akan disimpan.
     * @return true jika berhasil disimpan, false jika gagal.
     */
    @Override
    public boolean save(User user) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (name, username, password) VALUES (?, ?, ?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Memperbarui informasi pengguna yang ada di dalam database.
     * 
     * @param user Objek User yang telah diperbarui.
     * @return true jika berhasil diperbarui, false jika gagal.
     */
    @Override
    public boolean update(User user) {
        try {
            Connection connection = Database.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET name = ?, username = ?, password = ? WHERE user_id = ?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getUser_id());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Menghapus pengguna dari database berdasarkan ID pengguna.
     * 
     * @param user_id ID dari pengguna yang akan dihapus.
     */
    @Override
    public void delete(int user_id) {

    }
    
}
