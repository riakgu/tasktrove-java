package tasktrove.dao;

import java.sql.ResultSet;
import tasktrove.model.Task;

public interface TaskDao {
    ResultSet getAll(int user_id);
    Task get(int task_id);
    int getUndone(int user_id);
    int getTotal(int user_id);
    boolean save(Task task);
    boolean update(Task task);
    boolean delete(int task_id);
}
