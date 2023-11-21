import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    private void search (String name){

        String theSearch = ui.getInput("Search for a movie or series");


        boolean mediaFound = false;
        Media media = null;
        for(Media movieSeries: medias)
        {
            if(movieSeries.getName().equalsIgnoreCase(theSearch))
            {
                mediaFound = true;
                media = movieSeries;
                break;
            }
        }

        if(mediaFound)
        {
            List<String> options = new ArrayList<>();
            options.add("Play");
            options.add("Add to favorites");
            options.add("Remove form favorites");
            int choice = ui.getChoice("What do you wanna d ? ", options );

        } else
        {
            ui.displayMessage("The movie or series " + media + " isn't on our platform");
        }

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
