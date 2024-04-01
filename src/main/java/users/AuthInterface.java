package users;

import java.sql.SQLException;

public interface AuthInterface {
    public LoggedUser login(String username, String password) throws SQLException;
    public void logout() throws SQLException;
}
