import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AMenu{
    private final List<Media> medias;
    private boolean running;

    public MainMenu() {
        medias = new ArrayList<>();
    }

    @Override
    public void setup() {
        loadMedia();
        runMainMenuLoop();
    }

    private void runMainMenuLoop (){
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
                    String mediaName = ui.getInput("What's the name of the media you wish to find? ");
                    search(mediaName);
                    break;
                case 5:
                    String mediaCategory = ui.getInput("What category would you like look in? ");
                    searchCategory(mediaCategory);
                    break;
                case 6:
                    logout();
                    break;
            }
        }
    }

    private Media search (String name){
        return null;
    }

    private Media [] searchCategory(String category){
        return null;
    }

    private void showMediaList() {

    }

    private void showUserWatchedList(){
    }

    private void showUserFavoritesList() {

    }

    private boolean addToFavourites(Media media){
        return false;
    }

    private boolean removeFromFavourites(Media media){
        return false;
    }

    private void chooseMedia (Media media){

    }

    public void addMedia (Media media){
        medias.remove(media);
    }

    public void removeMedia (Media media){
        medias.add(media);
    }

    public void loadMedia(){

    }

    private void logout(){
        running = false;
    }
}
