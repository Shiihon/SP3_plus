import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class FileIO implements IO {

    public ArrayList<String> readData(String path) {

        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                data.add(s);

            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return data;
    }

    @Override
    public void saveMediasData(String path, ArrayList<Media> media) {

        try {
            FileWriter writer = new FileWriter(path);
            writer.write("Titel");
            for (Media mediaList : media) {
                String title = mediaList.getName();

                writer.write(title + ", " + mediaList.getReleasYears() + ", " + mediaList.getCategories() + ", " + mediaList.getRating() + "\n");
            }
        } catch (IOException e) {
            System.out.println("noget gik galt ved skrivning til fil og saveMedia");
        }
    }

    @Override
    public void saveUsersData(String path, Map<String, String> users) {
        try {

            FileWriter writer = new FileWriter(path);
            writer.write("Name, Password" + "\n");
            for (Map.Entry<String, String> entry : users.entrySet()) {
                String userName = entry.getKey();
                String userPassword = entry.getValue();
                String userInfo = userName + ", " + userPassword + "\n";

                writer.write(userInfo);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("noget gik galt ved skrivning til fil og userInfo");
        }
    }
}
