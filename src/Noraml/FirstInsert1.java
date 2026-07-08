package Noraml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstInsert1 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO emp (e_name,e_salary,e_city) VALUES ('aaa',343434,'amr')");
            statement.executeUpdate("INSERT INTO emp (e_name,e_salary,e_city) VALUES ('bbb',43434,'amd')");
            statement.executeUpdate("INSERT INTO emp (e_name,e_salary,e_city) VALUES ('ccc',34343,'rj')");
            statement.executeUpdate("INSERT INTO emp (e_name,e_salary,e_city) VALUES ('ABC',33434,'st')");

            System.out.println("Records Inserted Successfully.");

            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}