package PreparedStatementPKG.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStud12 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter Student Name : ");
        String sname = sc.next();

        System.out.printf("\nEnter Student Roll No. : ");
        int sroll = sc.nextInt();

        System.out.printf("\nEnter Student Address : ");
        String saddress = sc.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university",
                        "root",
                        ""
                );
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO student (s_name,s_roll,s_address) VALUES (?,?,?)");
            ps.setString(1,sname);
            ps.setInt(2,sroll);
            ps.setString(3,saddress);
            int rw = ps.executeUpdate();

            if ( rw > 0 ) {
                System.out.println("Record inserted...");
            } else {
                System.out.println("Record not Inserted...");
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
