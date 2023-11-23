import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileIO implements IO {

    @Override
    public List<String> readData(String path) {
        List<String> data = new ArrayList<>();
        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                data.add(s);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file " + file.getParentFile().getName() + "/" + file.getName());
        }

        return data;
    }

    @Override
    public void saveMediasData(String path, List<Media> mediaList) {
        File file = new File(path);
        ensureFileExistence(file);

        try {
            FileWriter writer = new FileWriter(file);
            for (Media media : mediaList) {
                writer.write(media.getClass().getSimpleName() + "; " + media + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: Something went wrong while writing media data to file " + file.getParentFile().getName() + "/" + file.getName() + ".");
        }
    }

    @Override
    public void saveUsersData(String path, Map<String, String> users) {
        File file = new File(path);
        ensureFileExistence(file);

        try {
            FileWriter writer = new FileWriter(file);
            for (Map.Entry<String, String> entry : users.entrySet()) {
                String userName = entry.getKey();
                String userPassword = entry.getValue();
                String userInfo = userName + ", " + userPassword + "\n";

                writer.write(userInfo);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: Something went wrong while writing user data to file " + file.getParentFile().getName() + "/" + file.getName() + ".");
        }
    }

    @Override
    public boolean hasDataEntry(String path) {
        return new File(path).exists();
    }

    private void ensureFileExistence(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error: Could not create file " + file.getParentFile().getName() + "/" + file.getName());
        }
    }
}
