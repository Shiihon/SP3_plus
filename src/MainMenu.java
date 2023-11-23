import java.util.*;

public class MainMenu extends AMenu {
    private final Set<String> categorySet;
    private final List<Media> medias;
    private final FileIO io;
    private User user;
    private boolean running;

    public MainMenu() {
        categorySet = new HashSet<>();
        medias = new ArrayList<>();
        io = new FileIO();
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void setup() {
        loadMedia();

        ui.displayMessage("\n" + "Welcome " + user.getUserName());

        runMainMenuLoop();
    }

    private void runMainMenuLoop() {
        running = true;

        while (running) {
            ui.displayMessage("");

            ArrayList<String> options = new ArrayList<>();
            options.add("See the list of media");
            options.add("See your watch list");
            options.add("See your favorites list");
            options.add("Search for media by name");
            options.add("Search for medias in category");
            options.add("Logout");

            int choice = ui.getChoice("\n" + "What would you like to do? ", options);

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
        String theSearch = ui.getInput("\nSearch for a movie or series: ");

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
            ui.displayMessage("\nThe movie or series " + theSearch + " isn't on our platform");
            String input = ui.getChoiceYN("Do you wish to search for something else? ");

            switch (input) {
                case "Y":
                    search();
                    break;
                case "N":
                    break;
            }
        }
    }

    private void searchCategory() {
        List<String> options = new ArrayList<>(categorySet);
        options.add("Quit");

        ui.displayMessage("\nWe have the following categories: ");
        int choice = ui.getChoice("\nWhat category would you like to see? ", options);

        if (choice == options.size()) {
            return;
        }

        String search = options.get(choice - 1);
        List<Media> searchMatches = new ArrayList<>();

        for (Media media : medias) {
            for (String category : media.getCategories()) {
                if (category.equalsIgnoreCase(search)) {
                    searchMatches.add(media);
                    break;
                }
            }
        }

        ui.displayMessage("");

        if (searchMatches.isEmpty()) {
            ui.displayMessage("\nWe don't have any media with that category");
            String input = ui.getChoiceYN("Do you wish to search for a different category? ");

            switch (input) {
                case "Y":
                    searchCategory();
                    break;
                case "N":
                    break;
            }
        } else {
            options.clear();

            for (Media media : searchMatches) {
                options.add(media.toString());
            }

            options.add("Quit");

            int input = ui.getChoice("\nWhich media would you like to choose? ", options);
            if (input != options.size()) {
                Media media = searchMatches.get(input - 1);

                chooseMedia(media);
            }
        }
    }

    private void showMediaList() {
        int userChoice = ui.getChoice("\nWhich media would you like to choose? ", medias);
        Media media = medias.get(userChoice - 1);

        chooseMedia(media);
    }

    private void showUserWatchedList() {
        List<Media> chosenMovie = user.getWatchedList();

        if (chosenMovie.isEmpty()) {
            ui.displayMessage("\nYour watchlist is currently empty");
        } else {
            int userChoice = ui.getChoice("\nWhich media would you like to choose? ", chosenMovie);
            Media media = chosenMovie.get(userChoice - 1);

            chooseMedia(media);
        }
    }

    private void showUserFavoritesList() {
        List<Media> showMovies = user.getFavoriteList();

        if (showMovies.isEmpty()) {
            ui.displayMessage("\nYour favorite list is currently empty");
        } else {
            ui.displayMessage("");
            int userChoice = ui.getChoice("\nWhich media would you like to choose? ", showMovies);
            Media media = showMovies.get(userChoice - 1);

            chooseMedia(media);
        }
    }

    private void addToFavourites(Media media) {
        List<Media> favoriteList = user.getFavoriteList();

        if (!favoriteList.contains(media)) {
            favoriteList.add(media);
            ui.displayMessage("\n" + media.getName() + " has been added to your favorite list.");
        } else {
            ui.displayMessage("\nThe chosen media already exist in your favorite list.");
        }
    }

    private void removeFromFavourites(Media media) {
        List<Media> favoriteList = user.getFavoriteList();

        if (favoriteList.contains(media)) {
            favoriteList.remove(media);
            ui.displayMessage("\n" + media.getName() + " has been removed from your favorite list.");
        } else {
            ui.displayMessage("\nThe chosen media does not exist in your favorite list.");
        }
    }

    private void chooseMedia(Media media) {
        ui.displayMessage("\nYou have picked: " + media.getName() + "\n");

        List<String> options = new ArrayList<>();
        options.add("Play");
        options.add("Add to favorites");
        options.add("Remove form favorites");
        options.add("Quit");

        int choice = ui.getChoice("\nWhat do you wanna do? ", options);

        switch (choice) {
            case 1:
                playMedia(media);
                break;
            case 2:
                addToFavourites(media);
                break;
            case 3:
                removeFromFavourites(media);
                break;
        }
    }

    public void playMedia(Media media) {
        if (!user.getWatchedList().contains(media)) {
            user.getWatchedList().add(media);
        }

        media.play();
    }

    public void addMedia(Media media) {
        medias.add(media);
    }

    public void removeMedia(Media media) {
        medias.remove(media);
    }

    public void loadMedia() {
        categorySet.clear();

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

        categorySet.addAll(categoryList);

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
