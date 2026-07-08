package ProductTable;

import java.sql.*;
import java.util.Scanner;

public class CrudOperation19 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            while (true) {

                System.out.println("\n========== PRODUCT CRUD MENU ==========");
                System.out.println("1. Insert Record");
                System.out.println("2. Update Record");
                System.out.println("3. Display Records");
                System.out.println("4. Delete Record");
                System.out.println("5. Exit");
                System.out.print("Enter Your Choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO product(productname,price,quality) VALUES(?,?,?)");

                        System.out.print("Enter Product Name: ");
                        ps.setString(1, sc.next());

                        System.out.print("Enter Product Price: ");
                        ps.setInt(2, sc.nextInt());

                        System.out.print("Enter Product Quality: ");
                        ps.setString(3, sc.next());

                        int i = ps.executeUpdate();

                        if (i > 0)
                            System.out.println("Record Inserted Successfully.");
                        else
                            System.out.println("Record Not Inserted.");

                        break;

                    case 2:
                        PreparedStatement ps1 = con.prepareStatement(
                                "UPDATE product SET productname=?, price=?, quality=? WHERE pid=?");

                        System.out.print("Enter Product ID: ");
                        int pid = sc.nextInt();

                        System.out.print("Enter New Product Name: ");
                        ps1.setString(1, sc.next());

                        System.out.print("Enter New Product Price: ");
                        ps1.setInt(2, sc.nextInt());

                        System.out.print("Enter New Product Quality: ");
                        ps1.setString(3, sc.next());

                        ps1.setInt(4, pid);

                        int j = ps1.executeUpdate();

                        if (j > 0)
                            System.out.println("Record Updated Successfully.");
                        else
                            System.out.println("Record Not Found.");

                        break;

                    case 3:
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM product");

                        System.out.println("\n--------------------------------------------------------");
                        System.out.printf("%-5s %-20s %-10s %-15s\n",
                                "ID", "Product", "Price", "Quality");
                        System.out.println("--------------------------------------------------------");

                        while (rs.next()) {
                            System.out.printf("%-5d %-20s %-10d %-15s\n",
                                    rs.getInt("pid"),
                                    rs.getString("productname"),
                                    rs.getInt("price"),
                                    rs.getString("quality"));
                        }

                        break;

                    case 4:
                        PreparedStatement ps2 = con.prepareStatement(
                                "DELETE FROM product WHERE pid=?");

                        System.out.print("Enter Product ID to Delete: ");
                        ps2.setInt(1, sc.nextInt());

                        int k = ps2.executeUpdate();

                        if (k > 0)
                            System.out.println("Record Deleted Successfully.");
                        else
                            System.out.println("Record Not Found.");

                        break;

                    case 5:
                        con.close();
                        sc.close();
                        System.out.println("Program Closed.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice! Please Enter 1 to 5.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}