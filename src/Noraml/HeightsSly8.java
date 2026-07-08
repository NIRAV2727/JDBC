package Noraml;

import java.sql.*;

public class HeightsSly8 {
    static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM emp WHERE E_salary = (SELECT MAX(e_salary) FROM emp) ");

            while (rs.next()) {
                System.out.println("Employee ID     : " + rs.getInt("e_id"));
                System.out.println("Name            : " + rs.getString("e_name"));
                System.out.println("Salary          : " + rs.getInt("e_salary"));
                System.out.println("city            : " + rs.getString(4));
                System.out.println("Designation     : "+rs.getString("designation"));
                System.out.println("Department      : " + rs.getString(6));
                System.out.println("----------------------------");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
