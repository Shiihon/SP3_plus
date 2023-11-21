

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AMenu {
    private final List<Media> medias;
    private boolean running;
    private User user;

    public MainMenu() {
        medias = new ArrayList<>();
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
            int choice = ui.getChoice("What do you wanna do ? ", options);

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

        } else {
            ui.displayMessage("The movie or series " + theSearch + " isn't on our platform");
        }


    }

    private void searchCategory() {

        String search = ui.getInput("What category would you like to se ?");
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
        } else {

            List<String> options = new ArrayList<>();
            for (Media media : searchMatches) {
                options.add(media.getName());
            }

            int input = ui.getChoice("What would you like to watch?", options);
            Media media = searchMatches.get(input-1);

            options.clear();

            options.add("Play");
            options.add("Add to favorites");
            options.add("Remove form favorites");
            int choice = ui.getChoice("What do you wanna d ? ", options);

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

    }


    private void showMediaList() {

    }

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

    public void loadMedia() {

    }

    private void logout() {
        running = false;
    }
}
