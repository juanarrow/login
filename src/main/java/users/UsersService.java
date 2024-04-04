package users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class UsersService implements CRUD<User>{

    Connection conn;
    public UsersService(Connection conn){
        this.conn = conn;
    }
    @Override
    public ArrayList<User> query(String column, String value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<User> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    private ArrayList<User> _requestAll(String sql) throws SQLException{
        //Creamos el array que vamos a devolver
        ArrayList<User> result = new ArrayList<User>();
        //Construimos la consulta a realizar
        Statement statement = this.conn.createStatement();   

        // Ejectuamos la consulta
        ResultSet querySet = statement.executeQuery(sql);
        // Recorremos cada uno de los registro devueltos por la consulta
        while(querySet.next()) {
            //Obtenemos los datos del Individuo
            int id = querySet.getInt("id");
            String name = querySet.getString("name");
            String surname = querySet.getString("surname");
            String username = querySet.getString("username");
            result.add(new User(id, name, surname, username));
        } 
        //Cerramos la consulta
        statement.close();

        //Devolvemos el array de individuoes
        return result;
    }

    @Override
    public ArrayList<User> requestAll(String sortedBy) throws SQLException{
        String sql = "SELECT id, name, surname, username FROM users"+(sortedBy.length()>0?(" ORDER BY "+sortedBy):"");
        return this._requestAll(sql);
    }

    @Override
    public User requestById(long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestById'");
    }

    @Override
    public long create(User model) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public int update(User object) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
    
}
