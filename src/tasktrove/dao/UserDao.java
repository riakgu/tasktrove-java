package tasktrove.dao;

import tasktrove.model.User;

public interface UserDao {
    User getByUsername(String username);
    User getById(int user_id);
    boolean save(User user);
    boolean update(User user);
    void delete(int user_id);
}
