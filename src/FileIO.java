import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

public class FileIO implements IO {

    public ArrayList<String> readData(String path) {

        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);

        try{
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
                while(scanner.hasNextLine())
                {
                    String s =scanner.nextLine();
                    data.add(s);

                }

        } catch ( FileNotFoundException e ){
            System.out.println("file not found");
        }

        return data;

    }

    @Override
    public void saveMediasData(String path, ArrayList<Media> media) {

    }

    @Override
    public void saveUsersData(String path, Map<String, String> users) {

    }
}
