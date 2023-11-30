import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseIO implements IO {

    private static final String DB_URL = "jdbc:mysql://localhost/world";
    private static final String USER = "root";
    private static final String PASS = "Cph2023!!";

    @Override
    public List<String> readData(String path) {
        Connection connection = null;
        PreparedStatement statement = null;

        List<String> data = new ArrayList<>();

        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM streaming_service." + path;
            statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery(sql);

            /*while (rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int numberOfColumns = rsmd.getColumnCount();
                String[] columnData = new String[numberOfColumns - 1];

                for (int i = 1; i < numberOfColumns; i++) {
                    columnData[i - 1] = String.valueOf(rs.getObject(i + 1));
                }

                data.add(String.join("; ", columnData));
            }*/

            if (path.equalsIgnoreCase("movies")) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int year = rs.getInt("year");
                    String genre = rs.getString("genre");
                    float rating = rs.getFloat("rating");

                    data.add(name + "; " + year + "; " + genre + "; " + rating);
                }
            } else if (path.equalsIgnoreCase("series")) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int startYear = rs.getInt("startYear");
                    String endYear = rs.getString("endYear");
                    if (rs.wasNull()) {
                        endYear = "";
                    }
                    String genre = rs.getString("genre");
                    float rating = rs.getFloat("rating");
                    String seasons = rs.getString("seasons");

                    data.add(name + "; " + startYear + "-" + endYear + "; " + genre + "; " + rating + "; " + seasons);
                }
            } else if (path.equalsIgnoreCase("users")) {
                while (rs.next()) {
                    String name = rs.getString("userName");
                    String password = rs.getString("password");

                    data.add(name + "; " + password);
                }
            }

            //STEP 5: Clean-up environment
            rs.close();
            statement.close();
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
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return data;
    }

    @Override
    public void saveMediasData(String path, List<Media> media) {

    }

    @Override
    public void saveUsersData(String path, Map<String, String> users) {

    }

    @Override
    public boolean hasDataEntry(String path) {
        return false;
    }
}
