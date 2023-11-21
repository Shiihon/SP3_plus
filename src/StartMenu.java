import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartMenu extends AMenu {

    private IO io;

    private final Map<String, String> users;

    public StartMenu() {

        users = new HashMap<>();
        io = new FileIO();
    }

    private boolean login(String userName, String password) {

        if (users.containsKey(userName)) {
            String userPassword = users.get(userName);
            if (userPassword.equals(password)) {
                return true;
            } else {
                System.out.println("The entered password is wrong...");
            }
        } else {
            System.out.println("Username does not exist...");
        }
        return false;
    }


    private boolean register(String userName, String password) {
        if (users.containsKey(userName)) {
            ui.displayMessage("The username does already exist");
            return false;
        } else {
            users.put(userName, password);
            ui.displayMessage(userName + " has succesfully been registered...");
            return true;
        }
    }

    private void runUserDialog() {
        List<String> options = new ArrayList<>();
        options.add("Login");
        options.add("Register new user");
        options.add("Quit");
        int choice = ui.getChoice("What would you like to do?", options);

        switch (choice) {
            case 1:
                String usersUserName = ui.getInput("What is your username? ");
                String usersPassword = ui.getInput("What is your password? ");
                login(usersUserName, usersPassword);
                break;
            case 2:
                String choosenUsername = ui.getInput("What should your username be?");
                String choosenPassword = ui.getInput("What should your password be?");
                register(choosenUsername, choosenPassword);
                break;
            case 3:
                break;
        }
    }

    private void loadUserData(User user) {
        List<String> userWatchList = io.readData("data/userData/" + user.getUserName() + "/watched.txt");
        List<String> userFavouriteList = io.readData("data/userData/" + user.getUserName() + "/favourite.txt");

        for (String line : userWatchList) {
            user.getWatchedList().add(loadMedia(line));
        }
        for (String line : userFavouriteList) {
            user.getFavoriteList().add(loadMedia(line));
        }
    }

    private Media loadMedia(String data) {
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
            int endYear = Integer.parseInt(runningYearData[1].trim());

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

    @Override
    public void setup() {
        loadUsers();
        runUserDialog();
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
