import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AMenu{
    private final List<Media> medias;

    public MainMenu() {
        medias = new ArrayList<>();
    }

    @Override
    public void setup() {
        loadMedia();
        runMainMenuLoop();
    }

    private void runMainMenuLoop (){

    }

    private Media search (String name){
        return null;
    }

    private Media [] searchCategory(String category){
        return null;
    }

    private void showUserWatchedList(){
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

    }
}
