package DBAccess;


import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {

    public static List<User> customerList(){
        ArrayList<User> customers = new ArrayList<User>();

        String sql = "SELECT * FROM useradmin.users WHERE role = 'customer'";
        try {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String email = resultSet.getString("email");
                String pas = resultSet.getString("password");
                String role = resultSet.getString("role");
                User newUser = new User(email,pas,role);
                customers.add(newUser);
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
    /*public static ArrayList<User> customers() throws SQLException, ClassNotFoundException{
        ArrayList<User> returnList = new ArrayList<User>();

        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;

        Connection con = Connector.connection();
        String query = "SELECT * FROM Users WHERE role = 'customer'";
        statement = con.createStatement();
        // ResultSet sender dataen over i programmet
        resultSet = statement.executeQuery(query);

        //executeUpdate
        while (resultSet.next()){
            String email = resultSet.getString("email");
            String pas = resultSet.getString("password");
            String role = resultSet.getString("role");
            User tmpUser = new User(email, pas, role);
            returnList.add(tmpUser);
        }

        // Lukker efter mig:
        resultSet.close();
        statement.close();
        con.close();

        return returnList;
    }

     */
}
