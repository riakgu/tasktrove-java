package tasktrove.model;

public class Admin extends User {
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public void setName(String name) {
        super.setName(name + " (Admin)");
    }
}
