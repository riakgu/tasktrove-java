package tasktrove.controller;

import tasktrove.dao.UserDaoImpl;
import tasktrove.model.User;

/**
 * Kelas SettingsController bertanggung jawab untuk mengelola pengaturan
 * pengguna, termasuk memperbarui password dan informasi profil pengguna.
 */
public class SettingsController {
    
    private UserDaoImpl ud = new UserDaoImpl(); // Membuat instance UserDaoImpl untuk interaksi database.

    /**
     * Memperbarui password pengguna.
     *
     * @param user_id ID pengguna yang passwordnya akan diperbarui.
     * @param newPassword Password baru yang akan diatur.
     * @return boolean Mengembalikan true jika pembaruan berhasil, false jika gagal.
     */
    public boolean settingsPassword(int user_id, String newPassword) {
        User user = ud.getById(user_id); // Mendapatkan objek User berdasarkan user_id.
        user.setPassword(newPassword);   // Menetapkan password baru ke objek User.

        return ud.update(user); // Memperbarui data pengguna di database.
    }
    
    /**
     * Memperbarui profil pengguna, termasuk nama dan username.
     *
     * @param user_id ID pengguna yang profilnya akan diperbarui.
     * @param name Nama baru pengguna.
     * @param username Username baru pengguna.
     * @return boolean Mengembalikan true jika pembaruan berhasil, false jika gagal.
     */
    public boolean settingsProfile(int user_id, String name, String username) {
        User user = ud.getById(user_id); // Mendapatkan objek User berdasarkan user_id.
        user.setName(name);              // Menetapkan nama baru ke objek User.
        user.setUsername(username);      // Menetapkan username baru ke objek User.

        return ud.update(user); // Memperbarui data pengguna di database.
    }
}
