/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasktrove.dao;

import tasktrove.model.User;

/**
 *
 * @author riakgu
 */
public interface UserDao {
    User getByUsername(String username);
    User getById(int user_id);
    boolean save(User user);
    boolean update(User user);
    void delete(int user_id);
}
