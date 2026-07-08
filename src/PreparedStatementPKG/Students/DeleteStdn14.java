package PreparedStatementPKG.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStdn14 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter student Roll No. : ");
        int srn = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM student WHERE s_roll=(?)");
            ps.setInt(1,srn);
            int rw = ps.executeUpdate();

            if ( rw > 0 ) {
                System.out.println("Record deleted...");
            } else {
                System.out.println("Record not deleted...");
            }
            ps.close();
            connection.close();
            sc.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
