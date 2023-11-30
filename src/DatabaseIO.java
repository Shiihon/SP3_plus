import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class DatabaseIO implements IO{

    @Override
    public List<String> readData(String path) {
       ResultSet rs = DBConnector.readData("Select * from streaming_service." + path);

       try {
           while (rs.next()) {
            String name = rs.getString("name");
            int year = rs.getInt("year");
            String genre = rs.getString("genre");
            float rating = rs.getFloat("rating");

               System.out.println(name + " : " + year + " : " + genre + " : " + rating);
           }
       }
        catch(SQLException e) {
            System.out.println("Something went wrong...");
        }

        return null;
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
