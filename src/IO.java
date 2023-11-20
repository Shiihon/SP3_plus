import java.util.ArrayList;
import java.util.Map;

public interface IO {

    ArrayList<String> readData(String path);

    void saveMediasData(String path, ArrayList<Media> media);

    void saveUsersData(String path, Map<String, String> users);
}
