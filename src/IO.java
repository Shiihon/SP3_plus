import java.util.ArrayList;

public interface IO {

    ArrayList<String> readData(String path);

    void saveMediasData(String path, ArrayList<Media> media);

    void saveUsersData(String path, ArrayList<User> users);
}
