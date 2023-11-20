import java.util.ArrayList;

public interface IO {

    ArrayList<String> readData(String path);

    void saveData(String path, ArrayList<Media> media);
}
