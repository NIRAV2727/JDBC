package Noraml;

import java.sql.*;

public class AllSelect2 {
    static void main(String[] args) {
        int i = 1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM emp");

            while (rs.next()){
                System.out.println("record : "+i);
                i++;
                System.out.println("Employee id : "+rs.getInt("e_id"));
                System.out.println("Employee name : "+rs.getString("e_name"));
                System.out.println("Employee salary : "+rs.getInt("e_salary"));
                System.out.println("Employee city : "+rs.getString("e_city"));
                System.out.println("Employee designation : "+rs.getString("designation"));
                System.out.println("Employee department  : " + rs.getString(6));
                System.out.println("\n============================================\n");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
