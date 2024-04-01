package users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthService implements AuthInterface{
    Connection conn = null;

    public AuthService(Connection conn){
        this.conn = conn;
    }

    @Override
    public LoggedUser login(String username, String password) throws SQLException{
        //Varible conteniendo el Individuo a devolver
        LoggedUser result = null;
        //Construimos la consulta a realizar
        Statement statement = this.conn.createStatement();    
        String sql = String.format("SELECT id, name, surname FROM users WHERE username='%s' AND password='%s'", username, password);
        // Ejecución de la consulta
        ResultSet querySet = statement.executeQuery(sql);
        // Recorrido del resultado de la consulta
        if(querySet.next()) {
            //Obtenemos los datos del Individuo
            long id = querySet.getLong("id");
            String name = querySet.getString("name");
            String surname = querySet.getString("surname");
            result = new LoggedUser(id, name, surname, username);
        }
        //Cerramos la consulta
        statement.close();    
        //Devolvemos el individuo
        return result;
    }

    @Override
    public void logout() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }
    
}
