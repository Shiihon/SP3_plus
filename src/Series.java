import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Series extends AMedia {

    private final int endYear;
    private final Map<Integer,Integer> seasons;

    public Series(String name, float rating, int releaseYear, List<String> categories, int endYear, Map<Integer,Integer> seasons) {
        super(name, rating, releaseYear, categories);
        this.endYear = endYear;

        this.seasons = seasons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Series series = (Series) o;
        return getEndYear() == series.getEndYear() && Objects.equals(getSeasons(), series.getSeasons());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEndYear(), getSeasons());
    }

    public Map<Integer,Integer> getSeasons()
    {
        return seasons;
    }

    public int getEndYear()
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

        return String.format("%s; %d-%s; %s; %s; %s", getName(), getReleaseYear(), getEndYear() == -1 ? "" : getEndYear(), String.join(", ", getCategories()), ratingFormatter.format(getRating()), String.join(", ", seasonsData));
    }
}
