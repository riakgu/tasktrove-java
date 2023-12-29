package tasktrove.controller;

import tasktrove.model.User;
import tasktrove.dao.UserDaoImpl;

/**
 * Kelas AuthController bertanggung jawab untuk mengelola otentikasi pengguna.
 * Kelas ini menyediakan fungsi untuk login, registrasi, mendapatkan detail pengguna,
 * dan mengecek keberadaan pengguna.
 */
public class AuthController {
    
    private UserDaoImpl ud = new UserDaoImpl();
    
    /**
     * Melakukan proses login dengan memverifikasi username dan password.
     * 
     * @param username Username pengguna.
     * @param password Password pengguna.
     * @return boolean Mengembalikan true jika login berhasil, false jika gagal.
     */
    public boolean login(String username, String password) {
        User user = ud.getByUsername(username); // Mendapatkan data pengguna berdasarkan username.
        return user.getPassword().equals(password); // Membandingkan password yang dimasukkan dengan yang ada di database.
    }
    
    /**
     * Mendaftarkan pengguna baru ke dalam sistem.
     * 
     * @param name Nama pengguna.
     * @param username Username yang akan digunakan pengguna.
     * @param password Password pengguna.
     * @return boolean Mengembalikan true jika registrasi berhasil, false jika gagal.
     */
    public boolean register(String name, String username, String password) {
        User user = new User(); // Membuat objek User baru.
        user.setName(name); // Menetapkan nama untuk objek User.
        user.setPassword(password); // Menetapkan password untuk objek User.
        user.setUsername(username); // Menetapkan username untuk objek User.
        
        return ud.save(user); // Menyimpan objek User ke dalam database.
    }

    /**
     * Mendapatkan detail pengguna berdasarkan username.
     * 
     * @param username Username pengguna.
     * @return User Mengembalikan objek User yang berisi detail pengguna.
     */
    public User getUserDetails(String username) {
        return ud.getByUsername(username); // Mengembalikan detail pengguna dari database.
    }
    
    /**
     * Menentukan apakah pengguna dengan username tertentu sudah ada di sistem.
     * 
     * @param username Username yang akan dicek.
     * @return boolean Mengembalikan true jika pengguna sudah ada, false jika belum.
     */
    public boolean isUserExists(String username) {
        User user = ud.getByUsername(username); // Mendapatkan data pengguna berdasarkan username.
        return user.getUsername() != null; // Memeriksa apakah username tersebut sudah terdaftar di database.
    }
}
