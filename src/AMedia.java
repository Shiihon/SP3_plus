import java.util.ArrayList;

public abstract class AMedia implements Media {
    private String name;
    private float rating;
    private int releasYear;
    private ArrayList<String> categories;


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
    public ArrayList<String> getCategories() {
        return categories;
    }

    @Override
    public void play() {

    }

    @Override
    public String toString()
    {
        return null;
    }
}
