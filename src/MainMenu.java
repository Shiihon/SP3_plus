import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainMenu extends AMenu {
    private final List<Media> medias;
    private final FileIO io;
    private boolean running;
    private User user;

    public MainMenu() {
        medias = new ArrayList<>();
        io = new FileIO();
    }

    @Override
    public void setup() {
        loadMedia();

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
        String theSearch = ui.getInput("Search for a movie or series: ");

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
            chooseMedia(media);
        } else {

            ui.displayMessage("The movie or series " + theSearch + " isn't on our platform");
        }
    }


    private void searchCategory() {
        String search = ui.getInput("What category would you like to see? ");
        List<Media> searchMatches = new ArrayList<>();

        for (Media media : medias) {
            for (String category : media.getCategories()) {
                if (category.equalsIgnoreCase(search)) {
                    ui.displayMessage("We have: " + media.getName() + " " + media.getReleasYears() + " " + media.getRating() + "\n");
                    searchMatches.add(media);
                    break;
                }
            }
        }

        if (searchMatches.size() == 0) {
            ui.displayMessage("We dont have any movies or series with that category");
            searchCategory();
        } else {

            List<String> options = new ArrayList<>();
            for (Media media : searchMatches) {
                options.add(media.getName());
            }

            int input = ui.getChoice("What would you like to watch? ", options);
            Media media = searchMatches.get(input - 1);

            chooseMedia(media);
        }
    }

    private void showMediaList() {
        List<String> chosenMovie = new ArrayList<>();
        for (Media media : medias) {
            chosenMovie.add(media.getName());
        }
        int userChoice = ui.getChoice("Which movie would you like to choose?", chosenMovie);
        Media media = medias.get(userChoice - 1);

        chooseMedia(media);
    }

    private void showUserFavoritesList() {
        List<Media> showMovies = user.getFavoriteList();

        List<String> movies = new ArrayList<>();
        for (Media media : showMovies) {
            movies.add(media.getName());
        }
        int userChoice = ui.getChoice("Which movie would you like to choose?", movies);
        Media media = medias.get(userChoice - 1);

        chooseMedia(media);
    }

    private void addToFavourites(Media media) {
        List<Media> favoriteList = user.getFavoriteList();

        if (!favoriteList.contains(media)) {
            favoriteList.add(media);
            ui.displayMessage(media.getName() + " has been added to your favorite list.");
        } else {
            ui.displayMessage("The chosen movie does already exist in your favorite list.");
        }
    }

    private void removeFromFavourites(Media media) {
        List<Media> favoriteList = user.getFavoriteList();

        if (favoriteList.contains(media)) {
            favoriteList.remove(media);
            ui.displayMessage(media.getName() + " has been removed from your favorite list.");
        } else {
            ui.displayMessage("The chosen movie does not exist in your favorite list.");
        }
    }

    private void chooseMedia(Media media) {
        List<String> options = new ArrayList<>();
        options.add("Play");
        options.add("Add to favorites");
        options.add("Remove form favorites");
        int choice = ui.getChoice("What do you wanna do? ", options);

        switch (choice) {
            case 1:
                media.play();
                break;
            case 2:
                addToFavourites(media);
                break;
            case 3:
                removeFromFavourites(media);
                break;
        }
    }

    private void showUserWatchedList() {

        ui.displayMessage("This is all your watched movies and series");
        List<Media> searchMatches = new ArrayList<>();

        for (Media watched : user.getWatchedList()) {
            searchMatches.add(watched);
        }


        //chooseMedia();


    }

    public void addMedia(Media media) {
        medias.add(media);
    }

    public void removeMedia(Media media) {
        medias.remove(media);
    }

    public void loadMedia() {
        List<String> movies = io.readData("data/100bedstefilm.txt");

        for (String line : movies) {
            addMedia(createMedia(line, "Movie"));
        }

        List<String> series = io.readData("data/100bedsteserier.txt");
        for (String line : series) {
            addMedia(createMedia(line, "Series"));
        }
    }

    private Media createMedia(String data, String type) {
        String[] mediaData = data.split(";");
        String mediaName = mediaData[0].trim();
        String category = mediaData[2].trim();
        String[] categoryData = category.split(",");

        List<String> categoryList = new ArrayList<>();

        for (String categoryName : categoryData) {
            categoryList.add(categoryName.trim());
        }

        float rating = Float.parseFloat(mediaData[3].trim().replace(",", "."));

        if (type.equalsIgnoreCase("Movie")) {
            int yearOfRelease = Integer.parseInt(mediaData[1].trim());

            return new Movie(mediaName, rating, yearOfRelease, categoryList);
        } else if (type.equalsIgnoreCase("Series")) {
            String runningYears = mediaData[1].trim();
            String[] runningYearData = runningYears.split("-");
            int releaseYear = Integer.parseInt(runningYearData[0].trim());
            int endYear = -1;

            if (runningYearData.length > 1) {
                endYear = Integer.parseInt(runningYearData[1].trim());
            }

            String seasons = mediaData[4].trim();
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
        io.saveMediasData("data/userData/" + user.getUserName() + "/watched.txt", user.getWatchedList());
        io.saveMediasData("data/userData/" + user.getUserName() + "/favourite.txt", user.getFavoriteList());

        running = false;
    }
}
