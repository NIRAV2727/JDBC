package Noraml;

import java.sql.*;

public class EmpName9 {
    static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT e_name FROM emp ");

            while (rs.next()) {
                System.out.println("Name        : " + rs.getString("e_name"));
                System.out.println("----------------------------");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
