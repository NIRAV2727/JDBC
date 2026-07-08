package PreparedStatementPKG.Employees;

import java.sql.*;
import java.util.Scanner;

public class EmpNoDiisp10 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );
            System.out.print("Enter Employee id : ");
            int empid = sc.nextInt();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM emp WHERE e_id=(?)");
            pst.setInt(1,empid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()){
                System.out.println("Employee id          : " + rs.getInt(1));
                System.out.println("Employee name        : " + rs.getString(2));
                System.out.println("Employee salary      : " + rs.getInt(3));
                System.out.println("Employee city        : " + rs.getString(4));
                System.out.println("Employee designation : " + rs.getString(5));
                System.out.println("Employee department  : " + rs.getString(6));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
