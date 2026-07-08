package Noraml;

import java.sql.*;

public class EmpCount7 {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM emp");

            if (rs.next()) {
                System.out.println("Total Employees = " + rs.getInt(1));
            }

            rs.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}