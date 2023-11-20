import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StartMenu extends AMenu {

    private IO io;

    private final Map<String, String> users;

    public StartMenu() {

        users = new HashMap<>();
        io = new FileIO();
    }

    private boolean login(String userName, String password) {
        return false;
    }

    private boolean register(String userName, String password) {
        return false;
    }

    private void runUserDialog() {

    }

    private void loadUserData(String userName) {

    }

    @Override
    public void setup() {

    }

    public void loadUsers() {
        ArrayList<String> userDataList = io.readData("users.txt");
        users.clear();
        for (String line : userDataList) {
            String[] userData = line.split(",");
            String userName = userData[0].trim();
            String password = userData[1].trim();
            users.put(userName, password);
        }
    }

    public void saveUsers(ArrayList<User> registeredUsers) {

    }

}
