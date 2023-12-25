package tasktrove.controller;

import tasktrove.dao.UserDaoImpl;
import tasktrove.model.User;

/**
 * SettingsController bertanggung jawab untuk mengelola pengaturan pengguna, 
 * termasuk pembaruan kata sandi dan profil pengguna.
 */
public class SettingsController {
    
    private UserDaoImpl ud = new UserDaoImpl();
    
    /**
     * Memperbarui kata sandi pengguna di basis data.
     * 
     * @param user_id ID pengguna yang akan diperbarui kata sandinya.
     * @param newPassword Kata sandi baru untuk pengguna.
     * @return true jika pembaruan berhasil, false jika gagal.
     */
    public boolean settingsPassword(int user_id, String newPassword ) {
        User user = ud.getById(user_id);
        user.setPassword(newPassword);

        return ud.update(user);
    }
    
    /**
     * Memperbarui profil pengguna, termasuk nama dan nama pengguna.
     * 
     * @param user_id ID pengguna yang akan diperbarui profilnya.
     * @param name Nama baru untuk pengguna.
     * @param username Nama pengguna baru.
     * @return true jika pembaruan berhasil, false jika gagal.
     */
    public boolean settingsProfile(int user_id, String name, String username) {
        User user = ud.getById(user_id);
        user.setName(name);
        user.setUsername(username);

        return ud.update(user);
    }    
}
