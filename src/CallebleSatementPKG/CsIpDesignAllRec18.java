package CallebleSatementPKG;

import java.sql.*;
import java.util.Scanner;

public class CsIpDesignAllRec18 {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );
            CallableStatement cs = con.prepareCall("{call EmployeesDesignation(?)}");

            System.out.print("Enter Employees Designation : ");
            String des = sc.next();
            cs.setString(1,des);
           ResultSet rs = cs.executeQuery();


            System.out.println("\nEmployee Details");
            System.out.println("--------------------------------------------------------------");
            System.out.printf("%-5s %-10s %-10s %-15s %-15s %-15s\n",
                    "ID", "Name", "Salary", "City", "Designation", "Department");
            System.out.println("--------------------------------------------------------------");

            boolean found = false;

            while (rs.next()){

                found = true;
                System.out.printf("%-5d %-10s %-10d %-15s %-15s %-15s\n",
                        rs.getInt("e_id"),
                        rs.getString("e_name"),
                        rs.getInt("e_salary"),
                        rs.getString("e_city"),
                        rs.getString("designation"),
                        rs.getString("department"));

            }
            if (!found) {
                System.out.println("No employee found.");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
