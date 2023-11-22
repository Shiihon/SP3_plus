import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Series extends AMedia {

    private final int endYear;
    private final Map<Integer,Integer> seasons;

    public Series(String name, float rating, int releaseYear, List<String> categories, int endYear, Map<Integer,Integer> seasons) {
        super(name, rating, releaseYear, categories);
        this.endYear = endYear;

        this.seasons = seasons;
    }

    public Map<Integer,Integer> getSeasons()
    {
        return seasons;
    }

    public int getEndYears()
    {
        return endYear;
    }

    @Override
    public void play() {
        System.out.println("Playing " + getName() + "...");
    }

    @Override
    public String toString()
    {
        List<String> seasonsData = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : getSeasons().entrySet()) {
            seasonsData.add(entry.getKey() + "-" + entry.getValue());
        }

        return String.format("%s; %d-%s; %s; %s; %s", getName(), getReleasYears(), getEndYears() == -1 ? "" : getEndYears(), String.join(", ", getCategories()), ratingFormatter.format(getRating()), String.join(", ", seasonsData));
    }
}
