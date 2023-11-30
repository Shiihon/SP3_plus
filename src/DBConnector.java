import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    static final String DB_URL = "jdbc:mysql://localhost/world";
    static final String USER = "root";
    static final String PASS = "Cph2023!!";

    public static ResultSet readData(String sql) {

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return rs;
    }
}
