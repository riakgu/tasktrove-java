package tasktrove.model;

import java.sql.Date;
import java.util.logging.Logger;

public class Task {
    private int task_id;
    private int user_id;
    private String task_name;
    private String description;
    private Date started;
    private Date deadline;
    private String status;

    public int getTask_id() {
        return task_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStarted() {
        return started;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setUser_id(User user) {
        this.user_id = user.getUser_id();
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
