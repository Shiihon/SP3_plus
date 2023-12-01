import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartMenu extends AMenu {
    private final int MIN_USERNAME_LENGTH = 4;
    private final int MAX_USERNAME_LENGTH = 10;

    private final int MIN_LOWERCASE_COUNT = 2;
    private final int MIN_UPPERCASE_COUNT = 2;
    private final int MIN_NUMERIC_COUNT = 1;
    private final int MIN_SYMBOL_COUNT = 1;

    private final Map<String, String> users;
    private final IO io;
    private User user;

    public StartMenu() {
        users = new HashMap<>();
        //io = new FileIO();
        io = new DatabaseIO();
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public void setup() {
        user = null;

        runUserDialog();
    }

    private void runUserDialog() {
        List<String> options = new ArrayList<>();
        options.add("Login");
        options.add("Register new user");
        options.add("Quit");
        int choice = ui.getChoice("\n" + "What would you like to do? ", options);

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
        String userName = ui.getInput("\n" + "What is your username? ");

        while (!users.containsKey(userName)) {
            ui.displayMessage("The entered username does not exist.");
            userName = ui.getInput("What is your username? ");
        }

        String password = ui.getInput("What is your password? ");
        String userPassword = users.get(userName);

        while (!userPassword.equals(password)) {
            ui.displayMessage("The entered password is wrong...");
            password = ui.getInput("What is your password? ");
        }

        loadUserData(userName, password);
    }

    private void register() {
        String userName = ui.getInput("What should your username be? ");

        while (users.containsKey(userName) || !validateUserName(userName)) {
            if (users.containsKey(userName)) {
                ui.displayMessage("The entered username already exist.");
            }
            if (!validateUserName(userName)) {
                ui.displayMessage(String.format("The username must be between %d and %d characters.", MIN_USERNAME_LENGTH, MAX_USERNAME_LENGTH));
            }

            userName = ui.getInput("What is your username? ");
        }

        String password = ui.getInput("What should your password be? ");

        while (!validatePassword(password)) {
            if (!validatePassword(password)) {
                ui.displayMessage(String.format("The password must contain at least %s.", getPasswordRequirements()));
            }

            password = ui.getInput("What should your password be? ");
        }

        users.put(userName, password);
        ui.displayMessage(userName + " has successfully been registered...");

        loadUserData(userName, password);
        saveUsers();
    }

    private boolean validateUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return false;
        }
        return (userName.length() >= MIN_USERNAME_LENGTH && userName.length() <= MAX_USERNAME_LENGTH);
    }

    private boolean validatePassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        if (password.length() < 4 || password.length() > 100) {
            return false;
        }

        int lowerCaseLetters = 0;
        int upperCaseLetters = 0;
        int numbers = 0;
        int symbols = 0;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    upperCaseLetters++;
                } else {
                    lowerCaseLetters++;
                }
            }
            if (Character.isDigit(c)) {
                numbers++;
            }
            if (c >= 33 && c <= 46 || c >= 58 && c <= 64) {
                symbols++;
            }
        }

        return lowerCaseLetters >= MIN_LOWERCASE_COUNT && upperCaseLetters >= MIN_UPPERCASE_COUNT && numbers >= MIN_NUMERIC_COUNT && symbols >= MIN_SYMBOL_COUNT;
    }

    private void loadUserData(String userName, String password) {
        User user = new RegularUser(userName, password);

        /*if (io.hasDataEntry(StreamingService.pathWatched.replace("{userName}", user.getUserName()))) {
            List<String> userWatchList = io.readData(StreamingService.pathWatched.replace("{userName}", user.getUserName()));

            for (String line : userWatchList) {
                user.getWatchedList().add(createMedia(line));
            }
        }

        if (io.hasDataEntry(StreamingService.pathFavorite.replace("{userName}", user.getUserName()))) {
            List<String> userWatchList = io.readData(StreamingService.pathFavorite.replace("{userName}", user.getUserName()));

            for (String line : userWatchList) {
                user.getFavoriteList().add(createMedia(line));
            }
        }*/

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

        if (type.equalsIgnoreCase(Movie.class.getSimpleName())) {
            int yearOfRelease = Integer.parseInt(mediaData[2].trim());

            return new Movie(mediaName, rating, yearOfRelease, categoryList);
        } else if (type.equalsIgnoreCase(Series.class.getSimpleName())) {
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
        users.clear();

        if (!io.hasDataEntry(StreamingService.pathUserData)) {
            return;
        }

        List<String> userDataList = io.readData(StreamingService.pathUserData);

        for (String line : userDataList) {
            String[] userData = line.split(",");
            String userName = userData[0].trim();
            String password = userData[1].trim();
            users.put(userName, password);
        }
    }

    public void saveUsers() {
        io.saveUsersData(StreamingService.pathUserData, users);
    }

    private String getPasswordRequirements() {
        List<String> requirements = new ArrayList<>();

        if (MIN_LOWERCASE_COUNT > 0) {
            String str = MIN_LOWERCASE_COUNT + " lowercase character";

            if (MIN_LOWERCASE_COUNT > 1) {
                str += "s";
            }

            requirements.add(str);
        }
        if (MIN_UPPERCASE_COUNT > 0) {
            String str = MIN_UPPERCASE_COUNT + " uppercase character";

            if (MIN_UPPERCASE_COUNT > 1) {
                str += "s";
            }

            requirements.add(str);
        }
        if (MIN_NUMERIC_COUNT > 0) {
            String str = MIN_NUMERIC_COUNT + " numeric character";

            if (MIN_NUMERIC_COUNT > 1) {
                str += "s";
            }

            requirements.add(str);
        }
        if (MIN_SYMBOL_COUNT > 0) {
            String str = MIN_SYMBOL_COUNT + " symbol";

            if (MIN_SYMBOL_COUNT > 1) {
                str += "s";
            }

            requirements.add(str);
        }

        String lastRequirement = requirements.removeLast();
        return String.join(", ", requirements) + " and " + lastRequirement;
    }
}
