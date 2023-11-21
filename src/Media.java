import java.util.List;

public interface Media
{
    String getName();
    float getRating();
    int getReleasYears();
    List<String> getCategories();
    void play();

}
