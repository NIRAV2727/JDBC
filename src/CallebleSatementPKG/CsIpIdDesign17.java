package CallebleSatementPKG;

import java.sql.*;
import java.util.Scanner;

public class CsIpIdDesign17 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            CallableStatement cs = con.prepareCall("{call GetDesignation(?,?)}");

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            cs.setInt(1, id);

            cs.registerOutParameter(2, Types.VARCHAR);

            cs.execute();
            String designation = cs.getString(2);

            System.out.println("Designation : " + designation);

            cs.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}