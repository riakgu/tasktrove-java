package tasktrove.controller;

import tasktrove.model.User;
import tasktrove.dao.UserDaoImpl;

/**
 * AuthController mengelola proses autentikasi seperti login, pendaftaran,
 * dan pengecekan keberadaan pengguna dalam aplikasi.
 * Kelas ini berinteraksi dengan UserDaoImpl untuk melakukan operasinya.
 */
public class AuthController {
    
    private UserDaoImpl ud = new UserDaoImpl();
    
    /**
     * Melakukan upaya login menggunakan nama pengguna dan kata sandi.
     * 
     * @param username Username yang mencoba masuk.
     * @param password Kata sandi pengguna.
     * @return true jika login berhasil, false jika tidak.
     */
    public boolean login(String username, String password) {
        User user = ud.getByUsername(username);
        
        return user.getPassword().equals(password);
    }
    
    /**
     * Mendaftarkan pengguna baru dengan detail yang diberikan.
     * 
     * @param name Nama pengguna baru.
     * @param username Nama pengguna untuk pengguna baru.
     * @param password Kata sandi untuk pengguna baru.
     * @return true jika registrasi berhasil, false jika tidak.
     */
    public boolean register(String name, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUsername(username);
        
        return ud.save(user);
    }

    /**
     * Mendapatkan detail pengguna berdasarkan nama pengguna.
     * 
     * @param nama pengguna Nama pengguna.
     * @return Objek pengguna yang berisi detail pengguna.
     */
    public User getUserDetails(String username) {
        return ud.getByUsername(username);
    }
    
    /**
     * Memeriksa apakah pengguna dengan nama tertentu sudah ada dalam sistem.
     * 
     * @param username Nama pengguna yang akan diperiksa.
     * @return true jika pengguna ada, false jika tidak.
     */
    public boolean isUserExists(String username) {
        User user = ud.getByUsername(username);
        
        return user.getUsername() != null;
    }
}