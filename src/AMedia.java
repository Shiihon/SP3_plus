import java.text.DecimalFormat;
import java.util.List;

public abstract class AMedia implements Media {
    protected final DecimalFormat ratingFormatter;
    private final String name;
    private final float rating;
    private final int releasYear;
    private final List<String> categories;

    public AMedia(String name, float rating, int releasYear, List<String>categories)
    {
        this.name = name;
        this.rating= rating;
        this.releasYear = releasYear;
        this.categories = categories;

        ratingFormatter = new DecimalFormat("#.#");
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public float getRating()
    {
        return rating;
    }

    @Override
    public int getReleasYears()
    {
        return releasYear;
    }

    @Override
    public List<String> getCategories() {
        return categories;
    }

    @Override
    public abstract void play();

    @Override
    public String toString()
    {
        return String.format("%s; %d; %s; %s", getName(), getReleasYears(), String.join(", ", getCategories()), ratingFormatter.format(getRating()));
    }
}
