package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

        public static ArrayList<User> customerList(){
        ArrayList<User> customers = new ArrayList<User>();

        String sql = "SELECT * FROM useradmin.users WHERE role = 'customers'";
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String email = resultSet.getString("email");
                String pas = resultSet.getString("password");
                String role = resultSet.getString("role");
                User tmpUser = new User(email,pas,role);
                customers.add(tmpUser);
            }
            ps.close();
            resultSet.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("Fejl i forbindelsen til database.");
            e.printStackTrace();
        }
        return customers;
    }


}
