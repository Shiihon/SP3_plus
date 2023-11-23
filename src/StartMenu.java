import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartMenu extends AMenu {

    private final Map<String, String> users;
    private final IO io;
    private User user;

    public StartMenu() {
        users = new HashMap<>();
        io = new FileIO();
    }

    @Override
    public void setup() {
        user = null;

        loadUsers();
        runUserDialog();
    }

    private void runUserDialog() {
        List<String> options = new ArrayList<>();
        options.add("Login");
        options.add("Register new user");
        options.add("Quit");
        int choice = ui.getChoice("What would you like to do? ", options);

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                break;
        }
    }

    private void login() {
        String userName = ui.getInput("What is your username? ");

        while (!users.containsKey(userName)) {
            ui.displayMessage("The entered password is wrong...");
            userName = ui.getInput("What is your username? ");
        }

        String password = ui.getInput("What is your password? ");
        String userPassword = users.get(userName);

        while (!userPassword.equals(password)) {
            ui.displayMessage("The entered password is wrong...");
            password = ui.getInput("What is your password? ");
        }

        loadUser(userName, password);
    }

    private void register() {
        String userName = ui.getInput("What should your username be? ");

        while (!users.containsKey(userName)) {
            ui.displayMessage("The username does already exist");
            userName = ui.getInput("What is your username? ");
        }

        String password = ui.getInput("What should your password be? ");

        users.put(userName, password);
        ui.displayMessage(userName + " has succesfully been registered...");

        loadUser(userName, password);
        saveUsers();
    }

    public User getUser() {
        return this.user;
    }

    private void loadUser(String userName, String password) {
        User user = new RegularUser(userName, password);

        if (io.hasDataEntry("data/userData/" + user.getUserName() + "/watched.txt")) {
            List<String> userWatchList = io.readData("data/userData/" + user.getUserName() + "/watched.txt");

            for (String line : userWatchList) {
                user.getWatchedList().add(createMedia(line));
            }
        }

        if (io.hasDataEntry("data/userData/" + user.getUserName() + "/favourite.txt")) {
            List<String> userWatchList = io.readData("data/userData/" + user.getUserName() + "/favourite.txt");

            for (String line : userWatchList) {
                user.getFavoriteList().add(createMedia(line));
            }
        }

        this.user = user;
    }

    private Media createMedia(String data) {
        String[] mediaData = data.split(";");
        String type = mediaData[0].trim();
        String mediaName = mediaData[1].trim();
        String category = mediaData[3].trim();
        String[] categoryData = category.split(",");

        List<String> categoryList = new ArrayList<>();

        for (String categoryName : categoryData) {
            categoryList.add(categoryName.trim());
        }

        float rating = Float.parseFloat(mediaData[4].trim().replace(",", "."));

        if (type.equalsIgnoreCase("Movie")) {
            int yearOfRelease = Integer.parseInt(mediaData[2].trim());

            return new Movie(mediaName, rating, yearOfRelease, categoryList);
        } else if (type.equalsIgnoreCase("Series")) {
            String runningYears = mediaData[2].trim();
            String[] runningYearData = runningYears.split("-");
            int releaseYear = Integer.parseInt(runningYearData[0].trim());
            int endYear = -1;

            if (runningYearData.length > 1) {
                endYear = Integer.parseInt(runningYearData[1].trim());
            }

            String seasons = mediaData[5].trim();
            String[] numberOfSeasons = seasons.split(",");
            Map<Integer, Integer> seasonMap = new HashMap<>();

            for (String seasonsListing : numberOfSeasons) {
                String[] splittingSeasons = seasonsListing.split("-");
                int season = Integer.parseInt(splittingSeasons[0].trim());
                int numberOfEpisodes = Integer.parseInt(splittingSeasons[1].trim());

                seasonMap.put(season, numberOfEpisodes);
            }
            return new Series(mediaName, rating, releaseYear, categoryList, endYear, seasonMap);
        }

        return null;
    }

    public void loadUsers() {
        List<String> userDataList = io.readData("data/users.txt");
        users.clear();
        for (String line : userDataList) {
            String[] userData = line.split(",");
            String userName = userData[0].trim();
            String password = userData[1].trim();
            users.put(userName, password);
        }
    }

    public void saveUsers() {
        io.saveUsersData("data/users.txt", users);
    }

}
