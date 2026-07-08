package CallebleSatementPKG;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CrtPrcdWithParmr16 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            CallableStatement clb = connection.prepareCall("{call InsertEmployee2(?,?,?,?,?,?)}");

            System.out.print("Insert Employee ID : ");
            clb.setInt(1,sc.nextInt());

            System.out.print("\nInsert Name : ");
            clb.setString(2,sc.next());

            System.out.print("\nInsert Salary : ");
            clb.setDouble(3,sc.nextDouble());

            System.out.print("\nInsert City : ");
            clb.setString(4,sc.next());

            System.out.print("\nEnter Designation : ");
            clb.setString(5,sc.next());

            System.out.print("\nEnter Department : ");
            clb.setString(6, sc.next());

            clb.execute();
            System.out.println("Employee record inserted successfully.");

            clb.close();
            connection.close();
            sc.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
