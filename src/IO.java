import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IO {

    List<String> readData(String path);

    void saveMediasData(String path, List<Media> media);

    void saveUsersData(String path, Map<String, String> users);

    boolean hasDataEntry(String path);
}
