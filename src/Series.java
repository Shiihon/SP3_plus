import java.util.HashMap;
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

    }

    @Override
    public String toString()
    {
        return super.toString();
    }

}
