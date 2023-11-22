import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public abstract class AMedia implements Media {
    protected final DecimalFormat ratingFormatter;
    private final String name;
    private final float rating;
    private final int releaseYear;
    private final List<String> categories;

    public AMedia(String name, float rating, int releaseYear, List<String>categories)
    {
        this.name = name;
        this.rating= rating;
        this.releaseYear = releaseYear;
        this.categories = categories;

        ratingFormatter = new DecimalFormat("#.#");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AMedia aMedia = (AMedia) o;
        return Float.compare(getRating(), aMedia.getRating()) == 0 && getReleaseYear() == aMedia.getReleaseYear() && Objects.equals(getName(), aMedia.getName()) && Objects.equals(getCategories(), aMedia.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRating(), getReleaseYear(), getCategories());
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
    public int getReleaseYear()
    {
        return releaseYear;
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
        return String.format("%s; %d; %s; %s", getName(), getReleaseYear(), String.join(", ", getCategories()), ratingFormatter.format(getRating()));
    }
}
