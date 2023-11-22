import java.util.List;

public class Movie extends AMedia {

    public Movie(String name, float rating, int releasYear, List<String> categories) {
        super(name, rating, releasYear, categories);
    }

    @Override
    public void play() {
        System.out.println("Playing " + getName() + "...");
    }
}
