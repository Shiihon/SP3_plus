import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainMenu extends AMenu {
    private final List<Media> medias;
    private boolean running;
    private User user;
    private FileIO io;

    public MainMenu() {
        medias = new ArrayList<>();
        io = new FileIO();
    }

    @Override
    public void setup() {
        createMedia();

        ui.displayMessage("Welcome " + user.getUserName());

        runMainMenuLoop();
    }

    public void setUser(User user) {
        this.user = user;
    }

    private void runMainMenuLoop() {
        running = true;

        while (running) {
            // Se liste af alle film
            // Se watch liste
            // Se favorite liste
            // Search by name
            // Search by category
            // logout

            ArrayList<String> options = new ArrayList<>();
            options.add("See the list of media");
            options.add("See your watch list");
            options.add("See your favorites list");
            options.add("Search for media by name");
            options.add("Search for medias in category");
            options.add("Logout");

            int choice = ui.getChoice("What would you like to do? ", options);

            switch (choice) {
                case 1:
                    showMediaList();
                    break;
                case 2:
                    showUserWatchedList();
                    break;
                case 3:
                    showUserFavoritesList();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    searchCategory();
                    break;
                case 6:
                    logout();
                    break;
            }
        }
    }

    private void search() {
        String theSearch = ui.getInput("Search for a movie or series");

        boolean mediaFound = false;
        Media media = null;
        for (Media movieSeries : medias) {
            if (movieSeries.getName().equalsIgnoreCase(theSearch)) {
                mediaFound = true;
                media = movieSeries;
                break;
            }
        }

        if (mediaFound) {
            List<String> options = new ArrayList<>();
            options.add("Play");
            options.add("Add to favorites");
            options.add("Remove form favorites");
            int choice = ui.getChoice("What do you wanna d ? ", options);

        } else {
            ui.displayMessage("The movie or series " + theSearch + " isn't on our platform");
        }
    }

    private void searchCategory() {
    }

    private void showMediaList() {
      List <String> options = new ArrayList<>();
      List <String> movieOptions = io.readData("data/100bedstefilm.txt");
        int counter = 0;
        for(int i = 0; 1 < movieOptions.size(); i++){
            counter = + i;
            System.out.println(i);

        }

    }
   /* List<String> userDataList = io.readData("data/users.txt");
        users.clear();
        for (String line : userDataList) {
        String[] userData = line.split(",");
        String userName = userData[0].trim();
        String password = userData[1].trim();
        users.put(userName, password);*/

    private void showUserWatchedList() {
    }

    private void showUserFavoritesList() {

    }

    private void addToFavourites(Media media) {

    }

    private void removeFromFavourites(Media media) {

    }

    private void chooseMedia(Media media) {

    }

    public void addMedia(Media media) {
        medias.add(media);
    }

    public void removeMedia(Media media) {
        medias.remove(media);
    }

    public void createMedia() {
        List<String> movies = io.readData("data/100bedstefilm.txt");
        for (String line : movies) {
            addMedia(createMedia(line));
        }
        List<String> series = io.readData("data/100bedsteserier.txt");
        for (String line : series) {
            addMedia(createMedia(line));
        }
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

    private void logout() {
        running = false;
    }
}
