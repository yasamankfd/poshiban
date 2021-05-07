import com.sun.deploy.net.MessageHeader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class database {
    private static final String url = "jdbc:mysql://localhost:3306/dbms?user=root&password=1234567890Aos@os&useUnicode=true&characterEncoding=UTF-8";
    private static final String class_for_name = "com.mysql.jdbc.Driver";

    public static void addUser(int id, String name) {
        try {
            Class.forName(class_for_name).newInstance();
            Connection connection = DriverManager.getConnection(url);
            Statement state = connection.createStatement();

            state.execute("insert into customers (id, name) values (123,'anis');");

            state.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getUserName(int id){
        try {
            Class.forName(class_for_name).newInstance();
            Connection connection = DriverManager.getConnection(url);
            Statement state = connection.createStatement();

            ResultSet rs = state.executeQuery("select name from customers where id = " + id);
            rs.last();

            String user_name = rs.getString(1);

            rs.close();
            state.close();
            connection.close();

            return user_name;
        } catch (Exception e){
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    public static List<Customer> getAllUsers(int id){
        List<Customer> customers = new ArrayList<>();
        try {
            Class.forName(class_for_name).newInstance();
            Connection connection = DriverManager.getConnection(url);
            Statement state = connection.createStatement();

            ResultSet rs = state.executeQuery("select id,name from customers;");

            while (rs.next()) {
                //Customer customer = new Customer(rs.getInt(1),rs.getString(2));
                //customers.add(customer);
            }

            rs.close();
            state.close();
            connection.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return customers;
    }

}
