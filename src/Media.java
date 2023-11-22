import java.util.List;

public interface Media
{
    String getName();
    float getRating();
    int getReleaseYear();
    List<String> getCategories();
    void play();

}
