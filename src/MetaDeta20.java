import java.sql.*;

public class MetaDeta20 {

    static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/university",
                    "root",
                    ""
            );

            Statement st = con.createStatement();

            String[] tables = {"emp","product","student"};

            for (String table : tables){
                ResultSet rs = st.executeQuery("SELECT * FROM " + table);
                ResultSetMetaData sm = rs.getMetaData();
                
                System.out.println("\nTable Name : " + table);
                System.out.println("-------------------------");
                System.out.println("Number of column : " + sm.getColumnCount());

                for (int i = 1; i <= sm.getColumnCount(); i++) {
                    System.out.println("Column : " + i);
                    System.out.println("ID          : " + sm.getColumnName(i));
                    System.out.println("Type        : " + sm.getColumnType(i));
                    System.out.println("Size        : " + sm.getColumnDisplaySize(i));
                    System.out.println("-----------------------");
                    
                }
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
