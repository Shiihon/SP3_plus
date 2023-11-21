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

    private void loadUserData(User user) {
        ArrayList<String> userWatchList = io.readData("data/userData/" + user.getUserName() + "/watched.txt");
        ArrayList<String> userFavouriteList = io.readData("data/userData/" + user.getUserName() + "/favourite.txt");

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

        ArrayList<String> categoryList = new ArrayList<>();

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
        ArrayList<String> userDataList = io.readData("data/users.txt");
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
