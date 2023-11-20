import java.util.ArrayList;

public interface Media
{
    String getName();
    float getRating();
    int getReleasYears();
    ArrayList <String> getCategories();
    void play();

}
