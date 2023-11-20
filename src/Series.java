import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Series extends AMedia {

    private final int endYear;
    private Map<Integer,Integer> seasons;

    public Series(String name, float rating, int releasYear, ArrayList<String> categories, int endYear, Map<Integer,Integer> seasons) {
        super(name, rating, releasYear, categories);
        this.endYear = endYear;

        seasons = new HashMap<>();
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
    public String toString()
    {
        return null;
    }

}
